package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ControllerP {
    private Project[] projects;
    private Stage[] stages;
    private Unit[] units;

    public ControllerP(){

        projects= new Project[10];
        stages=new Stage[6];
        units=new Unit[50];

    }

    public boolean registerProject(String nameProject, String nameCustomer, int diaIPlan,int mesIPlan,int añoIPlan, int diaFPlan, int mesFPlan, int añoFPlan,  double budget, String managerGname, String managerGPhone, String managerCName, String managerCPhone){
        Calendar initialDate=createfecha(diaIPlan, mesIPlan, añoIPlan);
        Calendar finalDate=createfecha(diaFPlan, mesFPlan, añoFPlan);
        Project nuevoproyecto= new Project(nameProject, nameCustomer, initialDate, finalDate,budget, managerGname, managerGPhone, managerCName, managerCPhone);

        Calendar dateStagePI=createfecha(00, (1), 0000);
        Calendar dateStagePF=createfecha(00, (1), 0000);
        Calendar dateStageRI=createfecha(00, (1),0000);
        Calendar dateStageRF=createfecha(00, (1),0000);
        
        createStage(TypeStage.INICIO, dateStagePI, dateStagePF, dateStageRI, dateStageRF, StatusStage.POR_DEFINIR);
        

        boolean indicador1=false;
      
        for (int i=0; i<projects.length;i++){
        
            if (projects[i]==null && !indicador1){
                projects[i]=nuevoproyecto;
                indicador1=true;
        }
    }
        return indicador1;
    }

    public String showProjects(){
        String msg="";
        for (int i=0; i<projects.length;i++){
            if(projects[i] == null){
				return msg;
			} else {
				msg +="\n"+(i+1)+". "+ projects[i].toStringProjectminim();
			}
			} 
            return msg;
        }

    public boolean createStage(TypeStage TypeStage, Calendar dateStagePI, Calendar dateStagePF, Calendar dateStageRI, Calendar dateStageRF, StatusStage StatusStage){
        boolean indicador2=false;
        Stage nuevaetapa= new Stage(TypeStage,dateStagePI, dateStagePF, dateStageRI, dateStageRF, StatusStage);
        for (int i=0; i<stages.length;i++){
        
            if (stages[i]==null && !indicador2){
                stages[i]=nuevaetapa;
                indicador2=true;
            }
        }
        return indicador2;
    }

    public boolean editStage(int opcionStage, int dateDIE, int dateMIE, int dateAIE, int dateDFS, int dateMFS, int dateAFS){
        boolean indicador3=false;
        if(indicador3==false){
            Calendar nuevafecha=createfecha(dateDIE, dateMIE, dateAIE);
            stages[opcionStage].setdateStagePI(nuevafecha);

            Calendar nuevafecha1=createfecha(dateDFS, dateMFS, dateAFS);
            stages[opcionStage].setdateStagePF(nuevafecha1);
            indicador3=true;
        }
            
        return indicador3;
    }

    public boolean CulminateStage(int opcionStage, int dateDIR, int dateMIR, int dateAIR, int dateDFR,int dateMFR, int dateAFR, int nStatuS){
        boolean indicador4=false;
        
        Calendar nuevafecharealI=createfecha(dateDIR, dateMIR,dateAIR);
        Calendar nuevafecharealF=createfecha(dateDFR, dateMFR, dateAFR);

        if (nStatuS==1){
            stages[opcionStage].setdateStageRI(nuevafecharealI);
            stages[opcionStage].setdateStageRF(nuevafecharealF);
            stages[opcionStage].setStatusStage(StatusStage.APROBADA);
            indicador4=true;
        } else if(nStatuS==2){
            stages[opcionStage].setdateStageRI(nuevafecharealI);
            stages[opcionStage].setdateStageRF(nuevafecharealF); 
            stages[opcionStage].setStatusStage(StatusStage.NO_APROBADA);
            indicador4=true;
        }

        return indicador4;
    }

    public boolean nextStage(int contador, int opcionStage){
        boolean indicador5=false;
        Calendar fecha = new GregorianCalendar(00,01,00);
        
        stages[opcionStage].setStatusStage(StatusStage.POR_DEFINIR);
        stages[opcionStage].setdateStagePI(fecha);
        stages[opcionStage].setdateStagePF(fecha);
        stages[opcionStage].setdateStageRI(fecha);
        stages[opcionStage].setdateStageRF(fecha);
        
        if (contador==2){
            stages[opcionStage].setTypeStage(TypeStage.ANALISIS);
            indicador5=true;
        }else if(contador==3){
            stages[opcionStage].setTypeStage(TypeStage.DISEÑO);
            indicador5=true;
        }else if(opcionStage==4){
            stages[opcionStage].setTypeStage(TypeStage.EJECUCION);
            indicador5=true;
        }else if(opcionStage==5){
            stages[opcionStage].setTypeStage(TypeStage.CIERRE);
            indicador5=true;
        }else if(opcionStage==6){
            stages[opcionStage].setTypeStage(TypeStage.SEGUIMIENTO);
            indicador5=true;
        }else if(opcionStage==7){
            stages[opcionStage].setTypeStage(TypeStage.CONTROL);
            indicador5=true;
        }
        return indicador5;
    }

    public boolean registerUnit(String id, String description, int typeUnit, String learnedLessons, String namecolabo, String cargo, int contador1, int opcionProject) {
        Calendar fechaAproPRE=createfecha(00, 00, 00);
        Project ProjectoUnit=projects[opcionProject];
        String ProjectoUnidad=ProjectoUnit.getnameProject();
        String Publicada="NO";
        String URL="-Ninguno";


        Unit nuevacapsula= new Unit(id, description, TypeUnit.TECNICO , learnedLessons, namecolabo, cargo, StatusUnit.POR_DEFINIR, fechaAproPRE, ProjectoUnidad,Publicada,URL );
		boolean indicador=false;
        

		for (int i=0; i<units.length;i++){
        
            if (units[i]==null && !indicador){
            units[i]=nuevacapsula;
            indicador=true;
        }
        
        if (typeUnit==2){
            units[opcionProject].setTypeUnit(TypeUnit.GESTION);
        }else if(typeUnit==3){
            units[opcionProject].setTypeUnit(TypeUnit.DOMINIO);
        }else if(typeUnit==4){
            units[opcionProject].setTypeUnit(TypeUnit.EXPERIENCIAS);
        }
        
	}
		
		return indicador;
	}
    
    public boolean approveKnowledgeUnit(int capsulaCambiar, int cambio ) {
		boolean indicador=false;
        Calendar Calendario=Calendar.getInstance();
        int añoAPunit=Calendario.get(Calendar.YEAR);
        int mesAPunit=Calendario.get(Calendar.MONTH);
        int diaAPunit=Calendario.get(Calendar.DAY_OF_MONTH);

        Calendar fechaAprobacion=createfecha(diaAPunit, mesAPunit, añoAPunit);
        if(cambio==1){
            units[capsulaCambiar].setStatusUnit(StatusUnit.APROBADA);
            units[capsulaCambiar].setDateConfirm(fechaAprobacion);
            indicador=true;
        }else if(cambio==2){
            units[capsulaCambiar].setStatusUnit(StatusUnit.NO_APROBADA);
            indicador=true;
        }

        return indicador;
	}

    public boolean publishKnowledgeUnit(int capsulaCambiar, String URL){
        boolean indicador=false;
        if(indicador==false){
            units[capsulaCambiar].setURL(URL);
            units[capsulaCambiar].setPublish("-SI");
            indicador=true;
        }
       return indicador;
    }


    public String showUnit(int opcionstage){
        String msg="";
        msg+="\n"+units[opcionstage].toStringUM();
        return msg;
    }

    public String getAllKnowledgeUnits() {

		String msg = "";
		for (int i=0; i<units.length; i++){
            if(units[i]!=null){
            msg+= "\n"+ (i+1)+". "+units[i].toStringUMmF();
            }
         }
		return msg;

	}

    public String showStages(int opcionStage, int numerito){
        String msg="";
    
       if (numerito==1){
        msg=stages[opcionStage].toStringStageMax();
       }else{
        msg =stages[opcionStage].toStringStage();
       }
        return msg;
    }

    public String showAllUnit(){
        String msg="";

        for  (int i=0; i<units.length; i++){
            if(units[i]==null){
                return msg;
            }else{
                msg +="\n"+(i+1)+"."+units[i].toStringUMm();
            }
            
        }

        return msg;
    }


    public static Calendar createfecha(int dia, int mes, int año){
        Calendar fecha = new GregorianCalendar(año,mes,dia);
        return fecha;
    }



}
