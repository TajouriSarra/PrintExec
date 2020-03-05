
public class PrintExec {

	public static void main(String[] args) {
		
		int nbreArg = args.length;
		
		for (int i=0; i<nbreArg-2; i++) {
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