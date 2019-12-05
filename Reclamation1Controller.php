<?php

namespace TechBundle\Controller;


use AppBundle\Entity\User;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\Form\Extension\Core\Type\FormType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use TechBundle\Entity\Categorierec;
use TechBundle\Entity\Evenement;
use TechBundle\Entity\Reclamation;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;
use TechBundle\Entity\Reclamationadmin;
use TechBundle\Entity\Reclamationmembre;
use TechBundle\Form\ReclamationadminType;
use TechBundle\Form\ReclamationmembreType;
use TechBundle\Form\ReclamationType;
use TechBundle\Form\ValiderType;
use TechBundle\Repository\ReclamationmemRepository;

class ReclamationController extends Controller
{




    //affiche liste des reclamations du memebre dans le front (Membre)

    public function homeReclamationAction(Request $request)
    {
        $x=0;
        $y=0;
        $z=0;
        $test= new Reclamationmembre();
        $membre=$this->container->get('security.token_storage')->getToken()->getUser()->getId();
        $rec=$this->getDoctrine()->getManager()->getRepository(Reclamationmembre::class)->findBy(['id' => $membre]);


        //recherche dans la base de donnée les reclamation non traite et en cours de traitement

        








        foreach ($rec as $value) {
            $test=$value->getNamecat() ;
            if ($test == "event"){
             $x++;
            }
            if ($test == "workshop"){
                $y++;
            }
            if ($test == "formation"){
                $z++;
            }
             }

        $nbrTotal=count($rec);
        $x=($x/$nbrTotal)*100;
        $y=($y/$nbrTotal)*100;
        $z=($z/$nbrTotal)*100;


        $rec  = $this->get('knp_paginator')->paginate(
            $rec,
            $request->query->get('page', 1)/*le numéro de la page à afficher*/,
            2/*nbre d'éléments par page*/
        );

        return $this->render ("@Tech/Default/reclamation_home.html.twig",array('rec'=>$rec,'x'=>$x,'y'=>$y,'z'=>$z,'nbrTotal'=>$nbrTotal));

    }


    //affiche liste des reclamations du memebre dans le Back (Admin)

    public function AfficheRecAdminAction(){
        $rec=$this->getDoctrine()->getRepository(Reclamationmembre::class)->findBy(['etatrecmembre' => 'non traiter']);
        $nbr=count($rec);
        return $this->render ("@Tech/Default/crud_Rec.html.twig",array('rec'=>$rec,'nbr'=>$nbr));

    }


    //supprimer une reclamation dans le Back (Admin)

    public function SuppRecAdminAction(Request $request,$idrecmembre)
    {
        $em = $this->getDoctrine()->getManager();
        $Reclamation=$em->getRepository(Reclamationmembre::class)->find($idrecmembre);
        $em->remove($Reclamation);
        $em->flush();
        return $this->redirectToRoute("recAdmin");
    }


    //Membre ajout une reclamation

    public function AddRecMemebreAction(Request $request){
        $Reclamation = new Reclamationmembre();
        $membre=$this->container->get('security.token_storage')->getToken()->getUser()->getId();
        $allcategories=$this->getDoctrine()->getManager()->getRepository(Categorierec::class)->findAll();
        $form= $this->createForm(ReclamationmembreType::class,$Reclamation);
        $form=$form->handleRequest($request);

        if($form->isSubmitted() && $form->isValid())
        {

            $em = $this->getDoctrine()->getManager();
            $em = $this->getDoctrine()->getManager();

            $date = new \DateTime('now');

            $manager = $this->get('mgilet.notification');


            $notif = $manager->createNotification("ticket ajouté par 1   ");
            $notif->setMessage(' aaa ');
            $tt=$em->getRepository(User::class)->findAll();
            foreach ($tt as $value) {

                    $manager->addNotification(array($value), $notif, true); }

            $etat="non traiter";
            $Reclamation->setId($membre);
            $Reclamation->setEtatrecmembre($etat);
            $a=date('d/m/Y');
            $Reclamation->setDaterecmembre(\DateTime::createFromFormat('d/m/Y', $a));
            $em->persist($Reclamation);
            $em->flush();
            return $this->redirectToRoute("reclam_home");
        }
        return $this->render('@Tech/Default/AddReclamation.html.twig', array('form' => $form->createView(),
            'categories'=>$allcategories
        ));
    }



    public function ReponseRecAdminTestAction($idrecmembre, Request $request){

        $Reclamation = new Reclamationadmin();
        $Reclamation = $this->getDoctrine()->getManager()->getRepository(Reclamationmembre::class)->find(idrecmembre);


        $form= $this->createForm(ReclamationType::class,$Reclamation);
        $form=$form->handleRequest($request);
        if($form->isSubmitted() && $form->isValid())
        {$em = $this->getDoctrine()->getManager();
            $etat="en cours";
            $Reclamation->setEtatReclamation($etat);
            $a=date('d/m/Y');
            $Reclamation->setDateR(\DateTime::createFromFormat('d/m/Y', $a));
            $em->persist($Reclamation);
            $em->flush();
            return $this->redirectToRoute("recAdmin");
        }
        return $this->render('@Tech/Default/ReponseAdminReclamation.html.twig', array('form' => $form->createView()));

    }

    public function ReponseRecAdminAction($idrecmembre, Request $request){

        $ReponseAdmin = new Reclamationadmin();
        $ReponseMembre = new Reclamationmembre();
        $ReclamationMembre = $this->getDoctrine()->getManager()->getRepository(Reclamationmembre::class)->find($idrecmembre);


        $form= $this->createForm(ReclamationadminType::class,$ReponseAdmin);
        $form=$form->handleRequest($request);
        if($form->isSubmitted() && $form->isValid())
        {
            $em = $this->getDoctrine()->getManager();

            $titre=$ReclamationMembre->getTitrerecmembre();
            $cat=$ReclamationMembre->getNamecat();
            $contenu=$ReclamationMembre->getContenurecmembre();
            $idrec=$ReclamationMembre->getIdrecmembre();
            $idmembre=$ReclamationMembre->getId();
            $date12= $ReclamationMembre->getDaterecmembre();

            $a=date('d/m/Y');
            $ReponseAdmin->setDaterecamin(\DateTime::createFromFormat('d/m/Y', $a));
            $ReponseAdmin->setTitrerecmembre($titre);
            $ReponseAdmin->setNamecat($cat);
            $ReponseAdmin->setContenurecadmin($contenu);
            $ReponseAdmin->setIdrecmembre($idrec);

            $etat="en cours";
            $b=date('d/m/Y');

            $ReclamationMembre->setEtatrecmembre($etat);
            $ReclamationMembre->setId($idmembre);
            $ReclamationMembre->setTitrerecmembre($titre);
            $ReclamationMembre->setContenurecmembre($contenu);
            $ReclamationMembre->setNamecat($cat);
            $ReclamationMembre->setDaterecmembre($date12);




            $em->persist($ReponseAdmin);
            $em->persist($ReclamationMembre);
            $em->flush();
            return $this->redirectToRoute("recAdmin");
        }
        return $this->render('@Tech/Default/ReponseAdminReclamation.html.twig', array('form' => $form->createView(),
            'categories'=>$ReclamationMembre
        ));

    }




    //affiche liste des reponse d'une reclamations front (membre)

    public function AfficheReponssMembreAction($idrecmembre, Request $request){
        $validation = new Reclamationmembre();
        $rec=$this->getDoctrine()->getRepository(Reclamationmembre::class)->findOneBy(['idrecmembre' => $idrecmembre ]);
        $rep = $this->getDoctrine()->getRepository(Reclamationadmin::class)->findBy(['idrecmembre' => $idrecmembre ]);
        $nbrReponse=count($rep);

        $form= $this->createForm(ValiderType::class,$rec);
        $form=$form->handleRequest($request);
        if($form->isSubmitted() && $form->isValid()){
            $em = $this->getDoctrine()->getManager();

            $titre=$rec->getTitrerecmembre();
            $cat=$rec->getNamecat();
            $contenu=$rec->getContenurecmembre();
            $idrec=$rec->getIdrecmembre();
            $idmembre=$rec->getId();
            $date12= $rec->getDaterecmembre();
            $etat="valider";
            $b=date('d/m/Y');

            $rec->setIdrecmembre($idrecmembre);
            $rec->setTitrerecmembre($titre);
            $rec->setContenurecmembre($contenu);
            $rec->setEtatrecmembre($etat);
            $rec->setDaterecmembre($date12);
            $rec->setId($idmembre);
            $rec->setNamecat($cat);



            $em->persist($rec);
            $em->flush();
            return $this->redirectToRoute("reclam_home");
        }


        return $this->render ("@Tech/Default/reclamationReponseMembre.html.twig",array('rec'=>$rec , 'rep'=>$rep, 'nbrReponse'=>$nbrReponse, 'form' => $form->createView()));

    }


    //affiche Archive des reclamationsValider dans le Back (Admin)

    public function archiveAdminAction(Request $request){
        $rec=$this->getDoctrine()->getRepository(Reclamationmembre::class)->findBy(['etatrecmembre' => 'valider']);
        return $this->render ("@Tech/Default/ArchiveAdminReclamation.html.twig",array('rec'=>$rec));

    }


    public function RecherchebtnrAction(Request $request)
    {
        return $this->render ("@Tech/Default/searchreclamation.html.twig");

    }

    //Recherche Reclamation

    public function searchDBAction(Request $request)
    {

        $em = $this->getDoctrine()->getManager();
        $requestString = $request->get('q');

        $entities = $rec=$this->getDoctrine()->getRepository(Reclamationmembre::class)->findBy(['titrerecmembre' => $requestString]);

        //$em->getRepository(ReclamationmemRepository::class)->findEntitiesByString($requestString);

        if(!$entities) {
            $result['entities']['error'] = "No results matche with your search ";
        } else {
            $result['entities'] = $this->getRealEntities($entities);
        }
        return new Response(json_encode($result));

    }

    public function getRealEntities($entities){
        foreach ($entities as $entity){
            $realEntities[$entity->getIdrecmembre()] = [$entity->getTitrerecmembre()];
        }
        return $realEntities;
    }

}
