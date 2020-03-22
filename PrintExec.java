
public class PrintExec {

	public static void main(String[] args) {
		
		int nbreArg = args.length;
		
		if (nbreArg==2) {System.out.println("javac -cp "+ args[0]+" "+args[1]);System.out.println("java "+ args[1]);return;}
		if (args[nbreArg-1].equals("true")) {System.out.println("javac -cp "+ args[nbreArg-3]+" "+args[nbreArg-2]+ ".java -s bin");System.out.println("java -cp "+args[nbreArg-3]+ " "+ args[nbreArg-2]);return;}
		for (int i=0; i<nbreArg-2; i++) {
			// Déplacer les fichiers .class dans le même répertoire du .java 
			System.out.print("cd "+ args[i]+ " /cp "+ args[i]+ " " + args[nbreArg-2]);
		}
		
		System.out.print("cd "+ args[nbreArg-2]+ " / javac "+ args[args.length-1]+".java");
		
		if (args[nbreArg].equals("true")) {
			System.out.print(" /mkdir bin");
			System.out.println(" /mv -v"+ args[nbreArg-1]+ ".class bin");
			
		}
		
		System.out.println("java "+ args[nbreArg-1]);
	}

}