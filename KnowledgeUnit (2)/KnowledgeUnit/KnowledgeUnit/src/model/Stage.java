package model;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Stage {
    private TypeStage TypeStage;
    private StatusStage StatusStage;
    private Calendar dateStagePI;
    private Calendar dateStagePF;
    private Calendar dateStageRI;
    private Calendar dateStageRF;


    private DateFormat formatter;



    public Stage(TypeStage TypeStage, Calendar dateStagePI, Calendar dateStagePF, Calendar dateStageRI, Calendar dateStageRF, StatusStage StatusStage){
        this.formatter = new SimpleDateFormat("dd/MM/yyyy");

        this.TypeStage=TypeStage;
        this.StatusStage=StatusStage;
        this.dateStagePI=dateStagePI;
        this.dateStagePF=dateStagePF;
        this.dateStageRI=dateStageRI;
        this.dateStageRF=dateStageRF;
    }

    public StatusStage getStatuStage(){
        return StatusStage;
    }

    public void setStatusStage(StatusStage StatusStage){
        this.StatusStage=StatusStage;
    }  

    public TypeStage getTypeStage(){
        return TypeStage;
    }

    public void setTypeStage(TypeStage TypeStage){
        this.TypeStage=TypeStage;
    }  

    public Calendar getdateStagePI(){
        return getdateStagePI();
    }

    public String getdateStagePIFormated(){
        return formatter.format(this.dateStagePI.getTime());
    }
    
    public void setdateStagePI(Calendar dateStagePI) {
        this.dateStagePI = dateStagePI;
    }
    
    
    public Calendar getdateStagePF(){
        return getdateStagePF();
    }

    public String getdateStagePFFormated(){
        return formatter.format(this.dateStagePF.getTime());
    }

    public void setdateStagePF(Calendar dateStagePF) {
        this.dateStagePF = dateStagePF;
    }

    public Calendar getdateStageRI(){
        return getdateStageRI();
    }

    public String getdateStageRIFormated(){
        return formatter.format(this.dateStageRI.getTime());
    }

    public void setdateStageRI(Calendar dateStageRI) {
        this.dateStageRI = dateStageRI;
    }

    public Calendar getdateStageRF(){
        return getdateStageRF();
    }

    public String getdateStageRFFormated(){
        return formatter.format(this.dateStageRF.getTime());
    }

    public void setdateStageRF(Calendar dateStageRF) {
        this.dateStageRF = dateStageRF;
    }


    public String toStringStage(){
		String msg="";
		msg ="\n        Etapa: "+ TypeStage +"\nEstado de la etapa: " + StatusStage+"\nFECHAS PREDEFINIDAS:"+"\nFecha planeada inicio: "+ getdateStagePIFormated() +"\nFecha planeada fin: "+ getdateStagePFFormated();
		return msg;
	}

    public String toStringStageMax(){
		String msg="";
		msg ="\n        Etapa: "+ TypeStage +"\nEstado de la etapa: " + StatusStage+"\nFecha planeada inicio: "+ getdateStagePIFormated() +"\nFecha planeada fin: "+ getdateStagePFFormated()+"\nFecha real inicio: "+getdateStageRIFormated()+"\nFecha real fin: "+getdateStageRFFormated();
		return msg;
	}


}
