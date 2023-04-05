package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Project {
    
    private String nameProject;
    private String nameCustomer;
	private Calendar initialDate;
	private Calendar finalDate;
    private double budget;
    private String managerGName;
    private String managerGPhone;
    private String managerCName;
    private String managerCPhone;

    private DateFormat formatter;

    public Project(String nameProject, String nameCustomer, Calendar initialDate ,Calendar finalDate,double budget, String managerGName, String managerGPhone,String managerCName, String managerCPhone){
        this.formatter = new SimpleDateFormat("dd/MM/yyyy");

        
        this.nameProject=nameProject;
        this.nameCustomer=nameCustomer;
        this.initialDate=initialDate;
        this.finalDate=finalDate;
        this.budget=budget;
        this.managerGName=managerGName;
        this.managerGPhone=managerGPhone;
        this.managerCName=managerCName;
        this.managerCPhone=managerCPhone;
    }

    public String getnameProject(){
        return nameProject;
    }

    public void setnameProject(String nameProject){
        this.nameProject=nameProject;
    }

    public String getnameCustomer(String nameCustomer){
        return nameCustomer;
    }

    public void setnameCustomer(String nameCustomer){
        this.nameCustomer=nameCustomer;
    }

    public Calendar getinitialDate(){
        return initialDate;
    }

    public String getInitialDateFormated() {
		return formatter.format(this.initialDate.getTime());
	}

	public Calendar getFinalDate(){
		return finalDate;
	}

	public String getFinalDateFormated(){
		return formatter.format(this.finalDate.getTime());
	}		


    public double getbudget(){
        return budget;
    }

    public void setbudget(double budget){
        this.budget=budget;
    }

    public String getmanagerGName(){
        return managerGName;
    }

    public void setmanagerGname(String managerGName){
        this.managerGName=managerGName;
    }

    public String getmanagerGPhone(){
        return managerGPhone;
    }

    public void setmanagerGPhone(String managerGPhone){
        this.managerGPhone=managerGPhone;
    }

    public String getmanagerCName(){
        return managerCName;
    }

    public void setmanagerCName(String managerCName){
        this.managerCName=managerCName;
    }

    public String getmanagerCPhone(){
        return managerCPhone;
    }

    public void setmanagerCPhone(String managerCPhone){
        this.managerCPhone=managerGPhone;
    }

    public String toStringProject(){
		String msg="";
		msg ="Nombre del proyecto: "+ nameProject + "\nNombre del cliente: " + nameCustomer+ "\nFecha planeada inicio: "+ getInitialDateFormated() +"\nFecha planeada fin: "+ getFinalDateFormated()+"\nPresupuesto proyecto: "+budget+"\nNombre gerente Green: "+managerGName+"\nTelefono gerente Green: "+managerGPhone+"\nNombre gerente cliente: "+managerCName+"\nTelefono gerente cliente: "+managerGPhone;
		return msg;
	}

    public String toStringProjectminim(){
        String msg="";
        msg="Nombre del proyecto: "+nameProject+"\nNombre del cliente: "+nameCustomer+"\nFecha planeada Inicio: "+getInitialDateFormated()+"\nFecha planeada fin: "+getFinalDateFormated()+"\nPresupuesto: "+budget+"\n";
        return msg;
    }

    
}
