package com.UT;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.rest.DoStuff;

public class MainUT {

	private static URLClassLoader classLoader;

	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

	        File helloWorldJava = new File("src/main/java/com/rest/AnnotationServer.java");
	        if (helloWorldJava.getParentFile().exists()) {

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
	                /********************************************************************************************* Compilation Requirements **/
	                if (task.call()) {
	                    classLoader = new URLClassLoader(new URL[]{new File("./").toURI().toURL()});
	                    // Load the class from the classloader by name....
	                    Class<?> loadedClass = classLoader.loadClass("com.rest.AnnotationServer");
	                    // Create a new instance...
	                    Object obj = loadedClass.newInstance();
	                    // Santity check
	                    if (obj instanceof DoStuff) {
	                        // Cast to the DoStuff interface
	                        DoStuff stuffToDo = (DoStuff)obj;
	                        // Run it baby
	                        stuffToDo.getPedidos();
	                        
	                        stuffToDo.crearPedido("Martin;Araoz 2287;4567-5555;milanesas");
	                        
	                        stuffToDo.modificarPedido("4;flan con dulce de leche");
	                        
	                        //stuffToDo.eliminarPedido("2");

	                    }
	                    /************************************************************************************************* Load and execute **/
	                } else {
	                    for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
	                        System.out.format("Error on line %d in %s%n",
	                                diagnostic.getLineNumber(),
	                                diagnostic.getSource().toUri());
	                    }
	                }
	                fileManager.close();
	        }
	    }
	
}
