package model;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Unit {


	private String id;
	private String description;
	private TypeUnit TypeUnit;
	private String learnedLessons;
	private String nameColabo;
	private String cargo;
	private StatusUnit StatusUnit;
	private Calendar DateConfirm;
	private String ProjectoUnidad;
	private String Publish;
	private String URL;

	private DateFormat formatter;


	public Unit(String id, String description, TypeUnit TypeUnit, String learnedLessons, String namecolabo, String cargo,StatusUnit StatusUnit, Calendar DateConfirm,String ProjectoUnidad, String Publish, String URL) {
		this.formatter = new SimpleDateFormat("dd/MM/yyyy");

		this.id = id;
		this.description = description;
		this.TypeUnit = TypeUnit;
		this.learnedLessons = learnedLessons;
		this.nameColabo = namecolabo;
		this.StatusUnit=StatusUnit;
		this.cargo=cargo;
		this.DateConfirm=DateConfirm;
		this.ProjectoUnidad=ProjectoUnidad;
		this.URL=URL;
		this.Publish=Publish;
	}

	public String getURL(String URL){
		return URL;
	}

	public void setURL(String URL){
		this.URL=URL;
	}

	public String getPublish(String Publish){
		return Publish;
	}

	public void setPublish(String Publish){
		this.Publish=Publish;
	}

	public String getProjectoUnidad(String ProjectoUnidad){
		return ProjectoUnidad;
	}

	public void setProjectUnit(String ProjectoUnidad){
		this.ProjectoUnidad=ProjectoUnidad;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TypeUnit getTypeUnit() {
		return TypeUnit;
	}

	public void setTypeUnit(TypeUnit TypeUnit) {
		this.TypeUnit = TypeUnit;
	}

	public StatusUnit getStatusUnit() {
		return StatusUnit;
	}

	public void setStatusUnit(StatusUnit StatusUnit) {
		this.StatusUnit = StatusUnit;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getnameColabo() {
		return nameColabo;
	}

	public void setnameColabo(String namecolabo) {
		this.nameColabo = namecolabo;
	}

	public String getLearnedLessons() {
		return learnedLessons;
	}

	public void setLearnedLessons(String learnedLessons) {
		this.learnedLessons = learnedLessons;
	}

	public String getCargo(){
		return cargo;
	}

	public void setCargo(String Cargo){
		this.cargo=Cargo;
	}

	public Calendar getDateConfirm(){
		return getDateConfirm();
	}

	public String getDateConfirmFormated(){
		return formatter.format(this.DateConfirm.getTime());
	}

	public void setDateConfirm(Calendar DateConfirm){
		this.DateConfirm=DateConfirm;
	}
	
	public String toStringU(){
		String msg="";
		msg ="Proyecto: "+ProjectoUnidad+"\nIdentificador: "+ id + "\nDescripion: " + description+ "\nTipo: "+ TypeUnit+"\nAprendizaje obtenido:"+learnedLessons+"\nEstado: "+StatusUnit+"\nNombre del colaborador: "+nameColabo+"\nCargo del colaborador: "+cargo;
		return msg;
	}

	public String toStringUM(){
		String msg="";
		msg ="Proyecto: "+ProjectoUnidad+"\nPublicada: "+Publish+"\nURL: "+URL+"\n"+"\n-Identificador: "+ id + "\nDescripion: " + description+ "\n-Tipo: "+ TypeUnit+"\nAprendizaje obtenido:"+learnedLessons+"\n-Estado: "+StatusUnit+"\nNombre del colaborador: "+nameColabo+"\n-Cargo del colaborador: "+cargo+"\nFecha de aprobacion: "+getDateConfirmFormated();
		return msg;
	}
	
	public String toStringUMm(){
		String msg="";
		msg ="Proyecto: "+ProjectoUnidad+"\nPublicada: "+Publish+"\nIdentificador: "+ id+ "\nTipo: "+ TypeUnit+"\nEstado: "+StatusUnit;
		return msg;
	}

	public String toStringUMmF(){
		String msg="";
		msg ="Proyecto: "+ProjectoUnidad+"\nPublicada: "+Publish+"\nURL: "+URL+"\nIdentificador: "+ id+ "\nTipo: "+ TypeUnit+"\nEstado: "+StatusUnit+"\nFecha de aprobacion: "+getDateConfirmFormated();
		return msg;
	}


}
