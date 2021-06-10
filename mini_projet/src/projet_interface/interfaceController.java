package projet_interface;


import javafx.beans.property.BooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Window;
import projet_departement.departement;
import projet_departement.direction;
import projet_departement_service.departementService;
import projet_departement_service.directionService;
import projet_employe.employe;
import projet_employe_service.employeService;

import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class interfaceController implements Initializable {

    @FXML
    private TextField numero;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField titre;
    @FXML
    private ChoiceBox affectation;
    @FXML
    private ChoiceBox niveau_poste;
    @FXML
    private TextField salaire;
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    @FXML
    private Button verifier;
    @FXML
    private Label message;
    @FXML
    private ChoiceBox option;
    @FXML
    private Label label_dep;
    @FXML
    private ChoiceBox cb_dep;
    @FXML
    private Label label_cat;
    @FXML
    private ChoiceBox cb_cat;
    @FXML
    private Label label_nv;
    @FXML
    private ChoiceBox cb_nv1;
    @FXML
    private ChoiceBox cb_nv2;
    @FXML
    private Button lister;
    @FXML
    private TableView<employe> table;
    @FXML
    private TableColumn<employe,Integer> t_numero;
    @FXML
    private TableColumn<employe,String> t_nom;
    @FXML
    private TableColumn<employe,String> t_prenom;
    @FXML
    private TableColumn<employe,String> t_affectation;
    @FXML
    private TableColumn<employe,String> t_titre;
    @FXML
    private TableColumn<employe,String> t_niveau;
    @FXML
    private TableColumn<employe,Double> t_salaire;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //intialize de la page Ajout/Modifier Employe
        ArrayList<direction> d = new ArrayList<direction>();
        ArrayList<String> list = new ArrayList<String>();
        d = new directionService().listerDir();
        Iterator<direction> i = d.iterator();
        while (i.hasNext()) {
            list.add(i.next().getLibelle());
        }
        ObservableList cb = FXCollections.observableArrayList(list);
        affectation.setItems(cb);

        ArrayList<String> nv_list = new ArrayList<String>();
        String[] nv = {"C", "G", "P", "E"};
        for (String c : nv) {
            for (int j = 1; j <= 6; j++) {
                nv_list.add(c + Integer.toString(j));
            }
        }
        ObservableList cb2 = FXCollections.observableArrayList(nv_list);
        niveau_poste.setItems(cb2);
        modifier.setVisible(FALSE);

        //Entialize de la page lister employe
        ArrayList<String> liste_option = new ArrayList<String>();
        liste_option.add("Lister tous les employés");
        liste_option.add("Lister par département");
        liste_option.add("Lister par catégorie");
        liste_option.add("Lister entre deux niveaux");
        liste_option.add("Lister ceux qui ont une voiture de fonction");
        ObservableList cb_option = FXCollections.observableArrayList(liste_option);
        option.setItems(cb_option);
        cb_dep.setItems(cb);
        label_dep.setVisible(FALSE);
        cb_dep.setVisible(FALSE);
        ArrayList<String> liste_categ = new ArrayList<String>();
        liste_categ.add("Les personnels cadres");
        liste_categ.add("Les gestionnaires");
        liste_categ.add("Les professionnels");
        liste_categ.add("Les employés");
        ObservableList cat = FXCollections.observableArrayList(liste_categ);
        cb_cat.setItems(cat);
        cb_cat.setVisible(FALSE);
        label_cat.setVisible(FALSE);
        cb_nv1.setItems(cb2);
        cb_nv2.setItems(cb2);
        label_nv.setVisible(FALSE);
        cb_nv1.setVisible(FALSE);
        cb_nv2.setVisible(FALSE);
        //Initialize pour page ajout/modifier departement
        ArrayList<employe> list_employe = new employeService().trouverTous();
        Iterator<employe> j = list_employe.iterator();
        ArrayList<Integer> list_em= new ArrayList<Integer>();
        while (j.hasNext()) {
            list_em.add(j.next().getNumero());
        }
        ObservableList cb_employe = FXCollections.observableArrayList(list_em);
        resp_dep.setItems(cb_employe);
        modifier_dep.setVisible(FALSE);
        //intialize ajouter/modifier direction
        directeur.setItems(cb_employe);
        ArrayList<departement> list_dep = new departementService().listerDep();
        ArrayList<String> list_dep_cb = new ArrayList<>();
        Iterator<departement> e = list_dep.iterator();
        while(e.hasNext()){
            list_dep_cb.add(e.next().getLibelle());
        }
        ObservableList cb_dep = FXCollections.observableArrayList(list_dep_cb);
        dir_dep.setItems(cb_dep);
        modifier_dir.setVisible(FALSE);
    }

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {

        Window owner = ajouter.getScene().getWindow();

        if (nom.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Form Error!");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir le nom");
            alert.initOwner(owner);
            alert.show();

        } else if (prenom.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Form Error!");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir le prenom");
            alert.initOwner(owner);
            alert.show();
        } else if (titre.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Form Error!");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir le titre");
            alert.initOwner(owner);
            alert.show();
        } else if (affectation.getItems().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Form Error!");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez choisir l'affectation");
            alert.initOwner(owner);
            alert.show();
        } else if (niveau_poste.getItems().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Form Error!");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez choisir le niveau du poste");
            alert.initOwner(owner);
            alert.show();
        } else if (salaire.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Form Error!");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir le salaire");
            alert.initOwner(owner);
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Registration successfully");
            alert.setHeaderText(null);
            if (new employeService().create(new employe(nom.getText(), prenom.getText(), titre.getText(), affectation.getValue().toString(), niveau_poste.getValue().toString(), Integer.parseInt(salaire.getText())))) {
                alert.setContentText("Employe ajouter avec success");
            } else {
                alert.setContentText("Employe non ajouter");
            }
            alert.initOwner(owner);
            alert.show();
        }
    }

    @FXML
    protected void handleEditButtonAction(ActionEvent event) {
        employe e= new employe(Integer.parseInt(numero.getText()),nom.getText(), prenom.getText(), titre.getText(), affectation.getValue().toString(), niveau_poste.getValue().toString(), Integer.parseInt(salaire.getText()));
        Boolean v = new employeService().update(Integer.parseInt(numero.getText()),e);
        Window owner = verifier.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Form Error!");
            alert.setHeaderText(null);
            if(v){
                alert.setContentText("Employe modifié !");
            }else {
                alert.setContentText("Erreur: employe n'est pas modifié !");
            }
            alert.initOwner(owner);
            alert.show();
    }


    public void seekEmploye(ActionEvent evnts) {
        Window owner = verifier.getScene().getWindow();
        if(numero.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Form Error!");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir un id");
            alert.initOwner(owner);
            alert.show();
        }else {
            try{
                int num = Integer.parseInt(numero.getText());
                    try {
                        message.setText("");
                        modifier.setVisible(TRUE);
                    employe e = new employeService().trouverParNumero(num);
                    nom.setText(e.getNom());
                    prenom.setText(e.getPrenom());
                    titre.setText(e.getTitre());
                    salaire.setText(String.valueOf(e.getSalaire()));
                    affectation.setValue(e.getAffectation());
                    niveau_poste.setValue(e.getNiveaux_poste());
                }catch (Exception e){
                    message.setText("Employe n'existe pas!");
                        modifier.setVisible(FALSE);
                        nom.setText("");
                        prenom.setText("");
                        titre.setText("");
                        salaire.setText("");
                        affectation.setValue("");
                        niveau_poste.setValue("");
                    }
            }catch(NumberFormatException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Form Error!");
                alert.setHeaderText(null);
                alert.setContentText("le numero doit être un entier");
                alert.initOwner(owner);
                alert.show();
            }

        }
    }

    public void verifOption(ActionEvent event) {
        String opt = option.getValue().toString();
        switch (opt){
            case "Lister par département":
                label_nv.setVisible(FALSE);
                cb_nv1.setVisible(FALSE);
                cb_nv2.setVisible(FALSE);
                label_cat.setVisible(FALSE);
                cb_cat.setVisible(FALSE);
                label_dep.setVisible(TRUE);
                cb_dep.setVisible(TRUE);
                break;
            case "Lister par catégorie":
                label_dep.setVisible(FALSE);
                cb_dep.setVisible(FALSE);
                label_nv.setVisible(FALSE);
                cb_nv1.setVisible(FALSE);
                cb_nv2.setVisible(FALSE);
                label_cat.setVisible(TRUE);
                cb_cat.setVisible(TRUE);
                break;
            case "Lister entre deux niveaux":
                label_dep.setVisible(FALSE);
                cb_dep.setVisible(FALSE);
                label_cat.setVisible(FALSE);
                cb_cat.setVisible(FALSE);
                label_nv.setVisible(TRUE);
                cb_nv1.setVisible(TRUE);
                cb_nv2.setVisible(TRUE);
                break;
            default:
                label_dep.setVisible(FALSE);
                cb_dep.setVisible(FALSE);
                label_cat.setVisible(FALSE);
                cb_cat.setVisible(FALSE);
                label_nv.setVisible(FALSE);
                cb_nv1.setVisible(FALSE);
                cb_nv2.setVisible(FALSE);
                break;
        }
    }

    public void listerEvent(ActionEvent event) {
        String opt = option.getValue().toString();
        ArrayList<employe> l = new ArrayList<employe>();
        switch (opt){
            case "Lister par département":
                l=new employeService().trouverParDep(cb_dep.getValue().toString());
                break;
            case "Lister par catégorie":
                String opt_cat = cb_cat.getValue().toString();
                String cat="E";
                switch(opt_cat){
                    case "Les personnels cadres":
                        cat ="C";
                        break;
                    case  "Les gestionnaires":
                        cat ="G";
                        break;
                    case  "Les professionnels":
                        cat ="P";
                        break;
                    case    "Les employés" :
                        cat ="E";
                        break;
                }

                l=new employeService().trouverParCategorie(cat);
                break;
            case "Lister entre deux niveaux":
                l=new employeService().trouverEntreDeuxNv(cb_nv1.getValue().toString(),cb_nv2.getValue().toString());
                break;
            case "Lister tous les employés":
                l=new employeService().trouverTous();
                break;
            case "Lister ceux qui ont une voiture de fonction":
                l=new employeService().trouverParCategorie("C");
                break;
        }
        ObservableList<employe> list_emp = FXCollections.observableArrayList(l);
        t_numero.setCellValueFactory(new PropertyValueFactory<employe,Integer>("numero"));
        t_nom.setCellValueFactory(new PropertyValueFactory<employe,String>("nom"));
        t_prenom.setCellValueFactory(new PropertyValueFactory<employe,String>("prenom"));
        t_titre.setCellValueFactory(new PropertyValueFactory<employe,String>("titre"));
        t_affectation.setCellValueFactory(new PropertyValueFactory<employe,String>("affectation"));
        t_niveau.setCellValueFactory(new PropertyValueFactory<employe,String>("niveaux_poste"));
        t_salaire.setCellValueFactory(new PropertyValueFactory<employe,Double>("salaire"));
        table.setItems(list_emp);
    }
    @FXML
    private TextField id_dep;
    @FXML
    private Button verifier_dep;
    @FXML
    private TextField libelle_dep;
    @FXML
    private ChoiceBox resp_dep;
    @FXML
    private Button modifier_dep;

    public void handleAjoutDepButton(ActionEvent event) {
        Window owner = verifier.getScene().getWindow();
        if (libelle_dep.getText().isEmpty())   {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Form Error!");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir le nom");
            alert.initOwner(owner);
            alert.show();
        }else if(resp_dep.getValue().toString().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Form Error!");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez choisir un responsable");
            alert.initOwner(owner);
            alert.show();
        }else{
            departement d = new departement(libelle_dep.getText(),Integer.parseInt(resp_dep.getValue().toString()));
            if(new departementService().ajouterDep(d)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Departement ajouté!");
                alert.setHeaderText(null);
                alert.setContentText("Département ajouté !");
                alert.initOwner(owner);
                alert.show();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("Impossible de faire l'ajout !");
                alert.initOwner(owner);
                alert.show();
            }
        }
    }

    public void handleVerifierDepartement(ActionEvent event) {
        try{
            int id =Integer.parseInt(id_dep.getText());
            modifier_dep.setVisible(TRUE);
            departement d = new departementService().findDep(id);
            libelle_dep.setText(d.getLibelle());
            resp_dep.setValue(d.getId_ges_resp());
        }catch(NumberFormatException e){
            Window owner = verifier_dep.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("ID doit être un entier !");
            alert.initOwner(owner);
            alert.show();
        }catch (Exception e){
            Window owner = verifier_dep.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Le département n'existe pas!");
            alert.initOwner(owner);
            alert.show();
        }
    }

    public void handleUpdateDepButton(ActionEvent event) {
        departement d = new departement(Integer.parseInt(id_dep.getText()),libelle_dep.getText(),Integer.parseInt(resp_dep.getValue().toString()));
        if(new departementService().updateDep(d)){
            Window owner = modifier_dep.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succes");
            alert.setHeaderText(null);
            alert.setContentText("Département modifié!");
            alert.initOwner(owner);
            alert.show();
        }else{
            Window owner = modifier_dep.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Impossible de modifier");
            alert.initOwner(owner);
            alert.show();
        }
    }
    @FXML
    private TextField id_dir;
    @FXML
    private ChoiceBox dir_dep;
    @FXML
    private ChoiceBox directeur;
    @FXML
    private TextField libelle_dir;
    @FXML
    private Button verifier_dir;
    @FXML
    private Button ajouter_dir;
    @FXML
    private Button modifier_dir;
    public void handleAjoutDirButton(ActionEvent event) {
        Window owner = verifier.getScene().getWindow();
        if (dir_dep.getValue().toString().isEmpty())   {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Form Error!");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez choisir une direction");
            alert.initOwner(owner);
            alert.show();
        }else if(directeur.getValue().toString().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Form Error!");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez choisir un directeur");
            alert.initOwner(owner);
            alert.show();
        }else if(libelle_dir.toString().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Form Error!");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir un libelle");
            alert.initOwner(owner);
            alert.show();
        }else{
            direction d = new direction(libelle_dir.getText(),Integer.parseInt(directeur.getValue().toString()),new departementService().getID(dir_dep.getValue().toString()));
            if(new directionService().ajouterDir(d)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Direction ajouté!");
                alert.setHeaderText(null);
                alert.setContentText("Direction ajouté !");
                alert.initOwner(owner);
                alert.show();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("Impossible de faire l'ajout !");
                alert.initOwner(owner);
                alert.show();
            }
        }
    }

    public void handleVerifierDirection(ActionEvent event) {
        try{
            int id =Integer.parseInt(id_dir.getText());
            modifier_dir.setVisible(TRUE);
            direction d = new directionService().findDir(id);
            libelle_dir.setText(d.getLibelle());
            dir_dep.setValue(new departementService().getLib(d.getId_dep()));
            directeur.setValue(d.getId_ges_resp());
        }catch(NumberFormatException e){
            Window owner = verifier_dir.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("ID doit être un entier !");
            alert.initOwner(owner);
            alert.show();
        }catch (Exception e){
            Window owner = verifier_dir.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("La direction n'existe pas!");
            alert.initOwner(owner);
            alert.show();
        }
    }

    public void handleUpdateDirButton(ActionEvent event) {
        direction d = new direction(Integer.parseInt(id_dir.getText()),libelle_dir.getText(),Integer.parseInt(directeur.getValue().toString()),new departementService().getID(dir_dep.getValue().toString()));
        if(new directionService().updateDir(d)){
            Window owner = modifier_dir.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succes");
            alert.setHeaderText(null);
            alert.setContentText("Direction modifié!");
            alert.initOwner(owner);
            alert.show();
        }else{
            Window owner = modifier_dir.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Impossible de modifier");
            alert.initOwner(owner);
            alert.show();
        }
    }
    @FXML
    public TreeView treeview;
    @FXML
    public Button lister_org_button;

    public void handleListerOrg(ActionEvent event) {

        TreeItem<String> rootItem = new TreeItem<> (new departementService().getLib(new departementService().getID("Entreprise")));
        treeview.setRoot(rootItem);
        ArrayList<departement> dep_list = new departementService().listerDep();
        Iterator<departement> i = dep_list.iterator();
        i.next();
        int j=-1;
        while(i.hasNext()){
            departement d = i.next();
            j++;
            rootItem.getChildren().add(new TreeItem(d.getLibelle()));
            ArrayList<direction> dir_list = new directionService().findDirParDep(d.getId_dep());
            Iterator<direction> i2 = dir_list.iterator();
            int j2=-1;
            while(i2.hasNext()){
                j2++;
                direction dir = i2.next();
                rootItem.getChildren().get(j).getChildren().add(new TreeItem(dir.getLibelle()));
                ArrayList<employe> dir_emp = new employeService().trouverParDep(dir.getLibelle());
                Iterator<employe> i3 = dir_emp.iterator();
                while(i3.hasNext()){
                    employe e =i3.next();
                    rootItem.getChildren().get(j).getChildren().get(j2).getChildren().add(new TreeItem(e.getNom()+" "+e.getPrenom()));
                }
            }
        }
    }
}
