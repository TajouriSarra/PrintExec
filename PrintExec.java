import java.util.ArrayList;

public class PrintExec {

	public static void main(String[] args) {
		
		int nbreArg = args.length;
		ArrayList<String> folders = new ArrayList<String>();
		
		   // Cas le plus simple avec 2 arguments 
		if (nbreArg==2) {
			String classFolder = args[0];
			String className = args[1];
			
			System.out.println("javac -sourcepath "+ classFolder+" "+className+ ".java");
			System.out.println("java -cp . "+ className);
		}
			// Cas avec le boolean 
		if (args[nbreArg-1].equals("true") || args[nbreArg-1].equals("false")) {
			
			// récupérer les class path
			for (int i=0; i < nbreArg-3; i++) {
				folders.add(args[i]);
			}
			
				//Cas où pas de chemin de librairies précisé
			if (folders.isEmpty()) {
					// Cas true
				if (args[nbreArg-1].equals("true")) {
					System.out.println("javac -sourcepath "+ args[0]+" -d bin "+args[1]+ ".java");
					System.out.println("java -cp . "+ args[1]);
				}else {
					// Cas false
					System.out.println("javac -sourcepath "+ args[0]+" "+args[1]+ ".java");
					System.out.println("java -cp . "+ args[1]);
				}
				
				// Cas où 1 ou plusieurs chemin renseigné
			}else{
					//Cas true
				if (args[nbreArg-1].equals("true")) {
			
					System.out.println("javac -sourcepath "+ args[nbreArg-3]+" -d bin "+args[nbreArg-2]+ ".java");
					System.out.print("java -cp .:");
					if (!folders.isEmpty()) {
						for (int index=0; index < folders.size()-1; index++) {
							System.out.print(folders.get(index)+":");
						}
					System.out.print(folders.get(folders.size()-1)+ " "+ args[nbreArg-2]);
					}
					//Cas false
				}else {
					System.out.println("javac -sourcepath "+ args[nbreArg-3]+" "+args[nbreArg-2]+ ".java");
					System.out.print("java -cp .:");
					if (!folders.isEmpty()) {
						for (int index=0; index < folders.size()-1; index++) {
							System.out.print(folders.get(index)+":");
						}
					}
					System.out.print(folders.get(folders.size()-1)+ " "+ args[nbreArg-2]);
				}
					
					
			}
			// Cas où le boolean non précisé
		}else {
			for (int i=0; i < nbreArg-2; i++) {
				folders.add(args[i]);
			}
			    //Cas où pas de chemin de librairies précisé 
			if (folders.isEmpty()) {
				System.out.println("javac -sourcepath "+ args[0]+" "+args[1]+ ".java");
				System.out.println("java -cp . "+ args[1]);
			}
			else{
				//Cas où 1 ou plusieurs chemin renseigné
				System.out.println("javac -sourcepath "+ args[nbreArg-2]+" "+args[nbreArg-1]+ ".java");
				System.out.print("java -cp .:");
				if (!folders.isEmpty()) {
					for (int index=0; index < folders.size()-1; index++) {
						System.out.print(folders.get(index)+":");
					}
				}
				System.out.print(folders.get(folders.size()-1)+ " "+ args[nbreArg-2]);
			}
		}
	}
}
	

