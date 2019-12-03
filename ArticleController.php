<?php

namespace TechBundle\Controller;
use Dompdf\Dompdf;
use Dompdf\Options;
use http\Client\Curl\User;
use TechBundle\Entity\Evenement;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use TechBundle\Entity\Article;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use TechBundle\Entity\FosUser;
use TechBundle\Form\ArticleType;
use Knp\Bundle\SnappyBundle\Snappy\Response\PdfResponse;
use Knp\Component\Pager\Pagination\AbstractPagination;
class ArticleController extends Controller
{

    public function indexBlogAction($id)
    {

        $em = $this->getDoctrine()->getManager();
        $article = $em->getRepository(Article::class)->find($id);
        $art = $em->getRepository(Article::class)->findAll();
        $article->setnbrevue($article->getnbrevue()+1);
        $em->persist($article);
        $em->flush();


        $ar = $em->getRepository(\TechBundle\Entity\User::class)->find($article->getIduser());
        $ar->getUsername();
        $events= $em->getRepository(\TechBundle\Entity\Evenement::class)->findAll();

        $queryBuilder = $em->getRepository('TechBundle:Article')->createQueryBuilder('bp');
        $queryBuilder->orderBy("bp.nbrevue", 'DESC');
        $event=$queryBuilder->getQuery();

        return $this->render("@Tech/Default/indexBlog.html.twig",array('articles'=>$article,'ar'=>$ar,'events'=>$event,'art'=>$art,'event'=>$events));

    }
    public function indexArticleAction(Request $request)
    {
        $em = $this->getDoctrine()->getManager();

        $queryBuilder = $em->getRepository('TechBundle:Article')->createQueryBuilder('bp');


        $queryBuilder->orderBy("bp.dateArticle", 'DESC');
if ($request->query->getAlnum('filter')){
    $queryBuilder
        ->where('bp.nomArticle LIKE :nomArticle')
        ->setParameter('nomArticle','%' . $request->query->getAlnum('filter') . '%');

}
$article=$queryBuilder->getQuery();

        /**
         * @var $paginator\Knp\Component\Pager\Paginator
         */
        $paginator  = $this->get('knp_paginator');

        $articles= $paginator->paginate(
            $article,
            $request->query->get('page', 1)/*le numéro de la page à afficher*/,
            6/*nbre d'éléments par page*/
        );


        return $this->render ("@Tech/Default/indexArticle.html.twig",array('articles'=>$articles));
    }


    public function showArticleAction(Request $request)
    {
        $em = $this->getDoctrine()->getManager();

        $listearticles = $em->getRepository('TechBundle:Article')->findAll();

        /**
         * @var $paginator\Knp\Component\Pager\Paginator
         */
        $paginator  = $this->get('knp_paginator');

        $articles= $paginator->paginate(
            $listearticles,
            $request->query->get('page', 1)/*le numéro de la page à afficher*/,
            6/*nbre d'éléments par page*/
        );
        return $this->render('@Tech/Default/Article_back.html.twig', array(
            'article' => $articles,
        ));
    }


    public function deleteArticleAction($id) {
        $em = $this->getDoctrine()->getManager();
        $article = $em->getRepository(Article::class)->find($id);
        $em->remove($article);
        $em->flush();
        return $this->redirectToRoute("article");
    }
    public function newArticleAction(Request $request)
    {

       $membre=$this->container->get('security.token_storage')->getToken()->getUser()->getId();

        $article = new Article();

        $form = $this->createForm(ArticleType::class,$article);
        $form = $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {

            $file= $request->files->get('techbundle_article')['imageArticle'];
            $uploads_directory=$this->getParameter('uploads_directory');

            $imageArticle=$file->getClientoriginalName();
            $em = $this->getDoctrine()->getManager();

            $file->move($uploads_directory,$imageArticle);
            $article->setImageArticle($imageArticle);
            $article->setIdUser($membre);

            $a=date('H:i:s d/m/Y');

            $article->setDateArticle($a);
            $b=0;
            $article->setNbrevue($b);
            $em->persist($article);
            $em->flush();
            return $this->redirect($this->generateUrl(
                "article", ['id' => $article->getIdArticle()]
            ));
        }
        return $this->render('@Tech/Default/Article_back_Add.html.twig',array('form' => $form->createView()));
    }
    public function editArticleAction($id , Request $request) {
        $article = new Article();
        $em = $this->getDoctrine()->getManager();
        $article = $em->getRepository(Article::class)->find($id);
        $form = $this->createForm(ArticleType::class,$article);
        $form = $form->handleRequest($request);
        if ($form->isSubmitted())
        {


            $file= $request->files->get('techbundle_article')['imageArticle'];
            $uploads_directory=$this->getParameter('uploads_directory');

            $imageArticle=$file->getClientoriginalName();


            $file->move($uploads_directory,$imageArticle);
            $article->setImageArticle($imageArticle);

            $a=date('H:i:s d/m/Y');

            $article->setDateArticle($a);
            $em->persist($article);
            $em->flush();
            return $this->redirectToRoute("article");
        }
        return $this->render('@Tech/Default/Article_back_Modifier.html.twig',array('form' => $form->createView()));


    }

    public function indexAction(Request $request)
    {



    }


    public function pdfAction($id)
    {
        $em = $this->getDoctrine()->getManager();
        $article = $em->getRepository(Article::class)->find($id);



        // Configure Dompdf according to your needs
        $pdfOptions = new Options();
        $pdfOptions->set('defaultFont', 'Arial');

        // Instantiate Dompdf with our options
        $dompdf = new Dompdf($pdfOptions);

        // Retrieve the HTML generated in our twig file

        $html = $this->renderView('@Tech/Default/pdf.html.twig', array('articles'=>$article) );



        // Load HTML to Dompdf
        $dompdf->loadHtml($html);

        // (Optional) Setup the paper size and orientation 'portrait' or 'portrait'
        $dompdf->setPaper('A4', 'portrait');

        // Render the HTML as PDF
        $dompdf->render();

        // Store PDF Binary Data
        $output = $dompdf->output();

        // In this case, we want to write the file in the public directory
        $publicDirectory = $this->get('kernel')->getProjectDir() . '/public';
        // e.g /var/www/project/public/pdf.pdf
        $pdfFilepath =  $publicDirectory . '/pdf.pdf';
        $dompdf->stream("pdf.pdf", [
            "Attachment" => false
        ]);
        // Write file to the desired path
        file_put_contents($pdfFilepath, $output);

        // Send some text response
        return new Response("The PDF file has been succesfully generated !");
    }

    public function indexEventAction($titre)
    {

      $articles = $this->getDoctrine()->getManager()->getRepository(Article::class)->findBytitreEvent($titre);


        return $this->render('@Tech/Default/indexEvent.html.twig', array(
            'article' => $articles,
        ));
    }




    public function addCommentAction(Request $request, UserInterface $user)
    {
        //if ($this->container->get('security.authorization_checker')->isGranted('IS_AUTHENTICATED_ANONYMOUSLY')) {
        //   return new RedirectResponse('/login');
        //}
        //$this->denyAccessUnlessGranted('IS_AUTHENTICATED_FULLY', null, 'unable to access this page.');
        $ref = $request->headers->get('referer');
        $post = $this->getDoctrine()
            ->getRepository(Post::class)
            ->findPostByid($request->request->get('post_id'));
        $comment = new Postcomment();
        $comment->setUser($user);
        $comment->setPost($post);
        $comment->setContent($request->request->get('comment'));
        $em = $this->getDoctrine()->getManager();
        $em->persist($comment);
        $em->flush();
        $this->addFlash(
            'info', 'Comment published !.'
        );
        return $this->redirect($ref);
    }

    public function deleteCommentAction(Request $request)
    {
        $id = $request->get('id');
        $em= $this->getDoctrine()->getManager();
        $comment=$em->getRepository('AppBundle:Postcomment')->find($id);
        $em->remove($comment);
        $em->flush();
        return $this->redirectToRoute('list_post');
    }
}
