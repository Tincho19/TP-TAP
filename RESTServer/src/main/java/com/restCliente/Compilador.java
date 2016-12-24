package com.restCliente;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;


public class Compilador {

	 public void compilarClaseRest(String nombreClase, String claseString) {


	        File helloWorldJava = new File("src/main/java/com/restCliente/"+nombreClase+".java");
	        if (helloWorldJava.getParentFile().exists() || helloWorldJava.getParentFile().mkdirs()) {

	            try {
	                Writer writer = null;
	                try {
	                    writer = new FileWriter(helloWorldJava);
//	                    writer.write(sb.toString());
	                    writer.write(claseString);
	                    writer.flush();
	                } finally {
	                    try {
	                        writer.close();
	                    } catch (Exception e) {
	                    }
	                }
	                
	                /*
	                /** Compilation Requirements *********************************************************************************************/
	                DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
	                JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
	                StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);

	                // This sets up the class path that the compiler will use.
	                // I've added the .jar file that contains the DoStuff interface within in it...
	                List<String> optionList = new ArrayList<String>();
	                optionList.add("-classpath");
	                optionList.add(System.getProperty("java.class.path") + ";dist/Compilador.jar");

	                Iterable<? extends JavaFileObject> compilationUnit
	                        = fileManager.getJavaFileObjectsFromFiles(Arrays.asList(helloWorldJava));
	                JavaCompiler.CompilationTask task = compiler.getTask(
	                    null, 
	                    fileManager, 
	                    diagnostics, 
	                    optionList, 
	                    null, 
	                    compilationUnit);
	                if (!task.call()) {
	                    for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
	                        System.out.format("Error on line %d in %s%n",
	                                diagnostic.getLineNumber(),
	                                diagnostic.getSource().toUri());
	                    }
	                }               
	                fileManager.close();
	            } catch (IOException e1){
	            	e1.printStackTrace();
	            }
	        }
	    }
	 

}
