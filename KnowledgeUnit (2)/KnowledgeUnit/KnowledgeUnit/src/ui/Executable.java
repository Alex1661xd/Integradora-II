package ui;


import java.util.Scanner;
import model.ControllerP;

public class Executable {

	private Scanner reader;
	private ControllerP controllerP;
	static int contador=1;
	static int contador1=0;

	public Executable() {
		reader = new Scanner(System.in);
		controllerP= new ControllerP();
	}


	public static void main(String[] args) {

		Executable exe = new Executable();
		exe.menu();

	}

	// Incompleto
	public void menu() {
		System.out.println("\nBienvenido a GreenSQA :)");
		boolean cond=false;

		while(!cond){
            System.out.println("\n-  Digite un numero  -");
            System.out.println("\n1. Crear Proyecto");
            System.out.println("2. Editar etapas de un proyecto");
            System.out.println("3. Culminar etapa de un proyecto");
			System.out.println("4. Registrar capsula");
			System.out.println("5. Aprobar capsula");
			System.out.println("6. Otras Funciones");
			System.out.println("\n7. Salir");
            int opcion=reader.nextInt();

            switch(opcion){
                case 1:
					registerProject();
                 break;

                case 2:
					editStage();
                break;

                case 3:
					CulminateStage();
                break;
      
                case 4:
					registerUnits();
                break;

				case 5:
					approveKnowledgeUnit();
				break;

				case 6:
					System.out.println("-Digite un numero-");
					System.out.println("1. Consultar Capsulas creadas");
					System.out.println("2. Publicar Capsula");
					int menu2=reader.nextInt();
						switch(menu2){
							case 1:
							showAllKnowledgeUnits();
							break;

							case 2:
							publishKnowledgeUnit();
							break;
						}
				break;
					
				case 7:
				System.out.println("Hasta luego :)");
                cond=true;
				break;


            }
        }
	}

	private void registerProject(){
		reader.nextLine();
		
		System.out.println("Ingrese la siguiente informacion para crear un proyecto:");
		System.out.println("Ingrese el nombre del proyecto");
		String nameProject=reader.nextLine();
		System.out.println("Ingrese el nombre del cliente");
		String nameCustomer=reader.nextLine();
		System.out.println("\n -FECHAS INICIO PROYECTO PLANEADA-");
		System.out.println("Ingrese el dia (En Numeros)");
		int diaIPlan=reader.nextInt();
		System.out.println("Ingrese el mes (En numeros)");
		int mesIPlan=reader.nextInt();
		System.out.println("Ingrese el año (En numeros)");
		int añoIPlan=reader.nextInt();

		System.out.println("\n-FECHA FINAL PLANEADA-");
		System.out.println("Ingrese el dia (En Numeros)");
		int diaFPlan=reader.nextInt();
		System.out.println("Ingrese el mes (En numeros)");
		int mesFPlan=reader.nextInt();
		System.out.println("Ingrese el año (En numeros)");
		int añoFPlan=reader.nextInt();
		
		System.out.println("\nIngrese el presupuesto para el proyecto");
		double budget=reader.nextDouble();
		reader.nextLine();
		System.out.println("Ingrese el nombre del gerente de Green");
		String managerGname=reader.nextLine();
		System.out.println("Ingrese el telefono del gerente de Green");
		String managerGPhone=reader.nextLine();
		System.out.println("Ingrese el nombre del gerente del cliente");
		String managerCName=reader.nextLine();
		System.out.println("Ingrese el telefono del gerente del cliente");
		String managerCPhone=reader.nextLine();

		if (controllerP.registerProject(nameProject,nameCustomer,diaIPlan,(mesIPlan-1),añoIPlan,diaFPlan,(mesFPlan-1),añoFPlan,budget,managerGname,managerGPhone,managerCName,managerCPhone)){
			System.out.println("\n       -Proyecto registrado exitosamente-");
			System.out.println("Primera Etapa INICIO creada con valores predeterminados");
		}else{
			System.out.println("     -No se pudo registrar. Memoria llena-");
		}
		
	}

	private void editStage(){
		reader.nextLine();
		String Consulta=controllerP.showProjects();
		if(Consulta.equals("")){
			System.out.println("Todavia no hay proyectos creados");
		}else{
			System.out.println("Estos los proyectos creados:");
			System.out.println(controllerP.showProjects());
			System.out.println("\nIngrese CON UN NUMERO a que proyecto desea editarle la etapa ");
			int opcionStage=reader.nextInt();
			System.out.println("\n-Esta es la etapa actual de ese proyecto:");
			int numerito=2;
			System.out.println(controllerP.showStages(opcionStage-1, numerito)); 
			System.out.println("\n       -MODO EDICION-");
			System.out.println("Ingrese la fecha inicial planeada");
			System.out.println("-Ingrese el dia");
			int dateDIE=reader.nextInt();
			System.out.println("\n-Ingrese el mes");
			int dateMIE=reader.nextInt();
			System.out.println("\n-Ingrese el año");
			int dateAIE=reader.nextInt();
			
			System.out.println("\nIngrese la fecha final planeada");
			System.out.println("-Ingrese el dia");
			int dateDFS=reader.nextInt();
			System.out.println("\n-Ingrese el mes");
			int dateMFS=reader.nextInt();
			System.out.println("\n-Ingrese el año");
			int dateAFS=reader.nextInt();
	
			if(controllerP.editStage((opcionStage-1), dateDIE, (dateMIE-1), dateAIE, dateDFS, (dateMFS-1), dateAFS)){
				System.out.println("\nEtapa editada correctamente");
			}else{
				System.out.println("No se puedo editar la etapa");
			}
		}
	

	}

	private void CulminateStage(){
		String Consulta=controllerP.showProjects();
		if(Consulta.equals("")){
			System.out.println("Todavia no hay proyectos creados");
		}else{
			System.out.println("Estos los proyectos creados:");
			System.out.println(controllerP.showProjects());
			System.out.println("\nIngrese CON UN NUMERO a que proyecto desea culminarle la etapa ");
			int opcionStage=reader.nextInt();
			System.out.println("\n-Esta es la etapa actual de ese proyecto:");
			int numerito=2;
			System.out.println(controllerP.showStages(opcionStage-1, numerito)); 
			
			System.out.println("\n-ESPACIO DE CULMINACION");
			System.out.println("\nIngrese la fecha real inicial");
			System.out.println("-Ingrese el dia");
			int dateDIR=reader.nextInt();
			System.out.println("\n-Ingrese el mes");
			int dateMIR=reader.nextInt();
			System.out.println("\n-Ingrese el año");
			int dateAIR=reader.nextInt();
	
			System.out.println("\nIngrese la fecha real final");
			System.out.println("-Ingrese el dia");
			int dateDFR=reader.nextInt();
			System.out.println("\n-Ingrese el mes");
			int dateMFR=reader.nextInt();
			System.out.println("\n-Ingrese el año");
			int dateAFR=reader.nextInt();
	
			System.out.println("\nIngrese con un NUMERO el nuevo estado de la Etapa");
			System.out.println("1.APROBADA \n2.NO APROBADA");
			int nStatuS=reader.nextInt();
	
	
			if (controllerP.CulminateStage((opcionStage-1), dateDIR, (dateMIR-1), dateAIR, dateDFR, (dateMFR-1), dateAFR, nStatuS)){
				int numerito1=1;
				System.out.println("\n  -Etapa culminada correctamente-");
				System.out.println("Asi quedo la etapa culminada");
				System.out.println(controllerP.showStages(opcionStage-1, numerito1));
				contador++;
				if(nStatuS==1){
					nextStages(contador, (opcionStage-1));
				} else if(nStatuS==2){
					System.out.println("NO SE PUEDE PASAR A LA SIGUIENTE ETAPA, PORQUE ESTA NO FUE APROBADA");
				}
				
			}else{
				System.out.println("   -No se pudo culminar-");
			}
		}
	
	}

	private void nextStages(int contador, int opcionStage){
		if(contador>7){
			System.out.println("TODAS LAS ETAPAS YA FUERON REGISTRADAS");
		}
		if(controllerP.nextStage(contador, opcionStage)){
			System.out.println("Nueva etapa creada exitosamente");
		}
	}

	private void registerUnits() {
		String Consulta=controllerP.showProjects();
		if (Consulta.equals("")){
			System.out.println("Todavia no hay proyectos creados");
		}else{
			System.out.println("\n- Ingrese la siguiente informacion:");
			System.out.println(controllerP.showProjects());
			System.out.println("¿A que proyecto desea registrarle la capsula?-Ingrese UN NUMERO");
			int opcionProject=reader.nextInt();
			int numerito=1;
			System.out.println("\nSe registrara la capsula a la siguiente etapa:");
			System.out.println(controllerP.showStages((opcionProject-1), numerito));
			System.out.println("\nCREACION CAPSULA DE CONOCIMIENTO");
			System.out.println("Ingrese el identificador de la capsula (Ej. A004)");
			reader.nextLine();
			String id=reader.nextLine();
			System.out.println("Añada una descripcion de la capsula");
			System.out.println("Marque con un ¨#¨ al inicio y fin de cada palabra clave");
			String description=reader.nextLine();
			System.out.println("\nIngrese el tipo de capsula con UN NUMERO");
			System.out.println("1.Tecnico\n2.Gestión\n3.Dominio\n4.Experiencias");
			int typeUnit=reader.nextInt();
			reader.nextLine();
			System.out.println("Ingrese aprendizaje obtenido");
			System.out.println("Marque con un ¨#¨ al inicio y fin de cada palabra clave");
			String learnedLessons=reader.nextLine();
			System.out.println("Ingrese el nombre del colaborador");
			String nameColabo=reader.nextLine();
			System.out.println("Ingrese el cargo de "+nameColabo);
			String cargo=reader.nextLine();
			contador1++;

			if (controllerP.registerUnit(id, description, typeUnit, learnedLessons,nameColabo,cargo,contador1, opcionProject-1)){
				System.out.println("\n-Capsula registrada exitosamente-");
				System.out.println("     -Asi quedo su capsula-");
				System.out.println(controllerP.showUnit(opcionProject-1)); 
			}else{
				System.out.println("\n-Memoria llena, no se pudo registrar la capsula-");
			}
		}


	}	

	// Incompleto 
	private void approveKnowledgeUnit() {
		String consulta= controllerP.showProjects();
		String consulta1= controllerP.showAllUnit();

		if(consulta.equals("")||consulta1.equals("")){
            System.out.println("No hay nada creado");
        }else{
            System.out.println("Estas son las capsulas registradas:");
            System.out.println(consulta1);
            System.out.println("Digite el numero de la capsula a cambiar");
            reader.nextLine();
			int capsulaCambiar=reader.nextInt();
			capsulaCambiar=capsulaCambiar-1;
            System.out.println("Escriba con un numero el nuevo estado \n1. Aprobada\n2. No aprobada");
			int cambio=reader.nextInt();
            if(controllerP.approveKnowledgeUnit(capsulaCambiar, cambio)){
				System.out.println("Capsula editada correctamente");
			}else{
				System.out.println("Ocurrio un error inesperado");
			}
        }

	}

	private void publishKnowledgeUnit(){
		String consulta= controllerP.showProjects();
		String consulta1= controllerP.showAllUnit();

		if(consulta.equals("")||consulta1.equals("")){
            System.out.println("No hay nada creado");
        }else{
            System.out.println("Estas son las capsulas registradas:");
            System.out.println(consulta1);
            System.out.println("Digite el numero de la capsula a publicar");
            reader.nextLine();
			int capsulaCambiar=reader.nextInt();
			capsulaCambiar=capsulaCambiar-1;
			reader.nextLine();
            System.out.println("Ingrese la URL de la capsula");
			String URL=reader.nextLine();
            if(controllerP.publishKnowledgeUnit(capsulaCambiar, URL)){
				System.out.println("Capsula publicada correctamente");
				System.out.println(controllerP.showUnit(capsulaCambiar));
			}else{
				System.out.println("Ocurrio un error inesperado");
			}
        }
	}

	private void showAllKnowledgeUnits() {
		System.out.println("Esta es la informacion registrada en el sistema");
        String consulta=controllerP.getAllKnowledgeUnits();

        if(consulta.equals("")){
            System.out.println("No hay capsulas registradas-");
			System.out.println("Cree una capsula primero");
        }else{
            System.out.println(consulta);
        }
	}

}