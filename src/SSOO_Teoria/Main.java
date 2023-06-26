package SSOO_Teoria;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Random;

public class Main {

	
	/*
	 * 		Pasos
	 *1) Crear un paquete llamado "SSOO_Teoria" DENTRO de la carpeta "src" de cualquier proyecto
	 * 
	 * 2) Copiar las clases Main.java y Pregunta.java en dicho paquete "SSOO_Teoria"
	 * 
	 * 3) Disfrutar y aprobar
	 * 
	 * Las preguntas no contestadas contarán como FALLO
	 * Este programa realiza 30 preguntas aleatorias sin repetir ninguna, si quieres que sean más preguntas, cambia el valor 
	 * del While de la linea 293	
	 */
	
	
	static Pregunta[] preguntas = { new Pregunta("Toda funcion de libreria realiza una llamada al sistema", "f"),
			new Pregunta(
					"En UNIX (un sistema multiusuario) un proceso de usuario puede utilizar llamadas al sistema para realizar operaciones E/S de una forma sencilla, o utilizar codigo ensamblador para trabajar directamente con los puertos de E/S de los controladores de los dispositivos",
					"f"),
			new Pregunta(
					"La multiprogramacion es posible debido a las interrupciones y a la existencia de unidades de procesamiento especifico para la E/S",
					"f"),
			new Pregunta("El S.O. esta formado por una serie de modulos software y hardware", "f"),
			new Pregunta("Algunas llamadas al sistema no implican la ejecucion de codigo del S.O.", "v"),
			new Pregunta(
					"En un S.O. multiusuario los procesos de usuario pueden inhibir las interrupciones, pero no lo suelen hacer, pues podrian paralizar el sistema",
					"f"),
			new Pregunta(
					"Los procesos de usuario pueden desactivar las interrupciones, pues se ejecutan en modo usuario",
					"f"),
			new Pregunta("En modo supervisor no es posible realizar operaciones de E/S", "f"),
			new Pregunta("En modo supervisor es posible realizar operaciones de E/S", "v"),
			new Pregunta(
					"En los sistemas operativos que se estructuran siguiendo el modelo cliente-servidor el sistema operativo controla la comunicacion entre servidores y clientes. Funciones tradicionales del sistema operativo, como el sistema de ficheros, se implementan como procesos de usuario.",
					"v"),
			new Pregunta(
					"El codigo de un sistema operativo (como UNIX) es siempre el mismo, independientemente del ordenador sobre el que se ejecute",
					"f"),
			new Pregunta(
					"A lo largo de la evolucion historica de los sistemas operativos se ha ido proporcionando una maquina virtual mas facil de utilizar, siempre a costa de una utilizacion menor de la CPU",
					"f"),
			new Pregunta(
					"Los canales y las interrupciones permiten la superposicion de las E/S con el procesamiento de instrucciones por la CPU",
					"v"),
			new Pregunta("El interprete de ordenes es un programa del S.O.", "v"),
			new Pregunta("Los interpretes de ordenes son programas que no tienen por que realizar llamadas al sistema",
					"f"),
			new Pregunta(
					"Una de las misiones del S.O. multiusuario es proteger los procesos y ficheros de un usuario de las acciones del resto de los usuarios",
					"v"),
			new Pregunta("Los editores se ejecutan en modo supervisor con total acceso al hardware del ordenador", "f"),
			new Pregunta(
					"Desde el interior de los programas, los servicios del sistema operativo se solicitan realizando llamadas al sistema",
					"v"),
			new Pregunta(
					"Debido a que una llamada al sistema implica utilizar instrucciones ensamblador, en C existen una o varias rutinas de biblioteca por cada llamada al sistema que aislan el codigo de la realizacion de la llamada",
					"v"),
			new Pregunta("Las ordenes internas de un S.O. llevan asociadas un fichero ejecutable en disco", "f"),
			new Pregunta("Los procesos de usuario tienen acceso a los puertos de E/S del controlador de la impresora",
					"v"),
			new Pregunta("Cuando un proceso realiza una operacion WAIT sobre un semaforo se bloquea", "v"),
			new Pregunta("Cuando un proceso realiza una operacion WAIT sobre un semaforo no siempre se bloquea", "f"),

			new Pregunta("El mecanismo de semaforos satisface la exclusion mutua entre procesos", "v"),
			new Pregunta(
					"En el sistema de designacion directa de mensajes el emisor y el receptor trabajan sobre buzones",
					"f"),
			new Pregunta("Un fichero de solo lectura es un recurso compartible", "v"),
			new Pregunta(
					"La solucion al problema de la exclusion mutua utilizando semaforos tiene la ventaja de que no se pierde tiempo de CPU en realizar espera ocupada",
					"v"),
			new Pregunta(
					"El hecho de que dos procesos quieran leer concurrentemente una misma zona de memoria plantea un problema de exclusion mutua",
					"f"),
			new Pregunta("Las operaciones WAIT y SIGNAL se realizan de forma indivisible", "v"),
			new Pregunta(
					"Varios procesos pueden estar ejecutando simultaneamente los procedimientos definidos en un monitor",
					"f"),
			new Pregunta(
					"Para realizar una operacion sobre semaforos es necesario realizar una llamada al sistema", "v"),
			new Pregunta("En modo supervisor no es posible realizar operaciones de E/S", "f"),
			new Pregunta("El mecanismo de semaforos no satisface la exclusion mutua entre procesos", "f"),
			new Pregunta(
					"Una de las misiones de un S.O. multiusuario es proteger a los procesos y ficheros de un usuario de la accion de los usuarios restantes",
					"v"),
			new Pregunta("El paso de mensajes permite la comunicacion entre procesos", "v"),
			new Pregunta(
					"Los interbloqueos (deadlock) no pueden ocurrir cuando hay tres procesos ejecutandandose concurrentemente",
					"f"),
			new Pregunta(
					"La instruccion TSL no se puede utilizar para implementar la exclusion mutua en un sistema formado por varios procesadores y una memoria principal comun",
					"f"),
			new Pregunta("Un Sistema Operativo solo gestiona los recursos no compartibles de un ordenador", "f"),
			new Pregunta("Un archivo con permisos de solo lectura puede ser un recurso compartible", "v"),
			new Pregunta("Una seccion critica puede ser un archivo", "f"),
			new Pregunta("Un semaforo se puede inicializar a un valor negativo", "f"),
			new Pregunta(
					"El paso de mensajes se pueden utilizar para la sincronizacion y comunicacion entre procesos", "v"),
			new Pregunta("Una variable de condicion es igual que un semaforo", "f"),
			new Pregunta(
					"'Espera ocupada' significa que un proceso que esta bloqueado a la espera de entrar en su seccion critica no consume tiempo de CPU",
					"v"),
			new Pregunta("Dentro de un monitor tan solo puede haber un proceso activo", "v"),
			new Pregunta(
					"Una operacion WAIT sobre un semaforo no debe ocurrir dentro de una seccion critica controlada por dicho semaforo que que se producira un interbloqueo",
					"v"),
			new Pregunta("Un semaforo binario solo se puede utilizar cuando el numero maximo de procesos es 2", "f"),
			new Pregunta("Un proceso del sistema puede desactivar las interrupciones", "f"),
			new Pregunta("Todo el software de un S.O. se encuentra en el nucleo de un S.O.", "f"),
			new Pregunta("Una operacion SIGNAL siempre desbloquea a un proceso", "f"),
			new Pregunta("Hay sistemas operativos modernos que no tienen API", "f"),
			new Pregunta("Una senal no es lo mismo que una interrupcion", "v"),
			new Pregunta("Una tuberia es un mecanismo de comunicacion con almacenamiento", "v"),
			new Pregunta("En una tuberia puede haber multiples procesos lectores pero un solo proceso escritor", "v"),
			new Pregunta("Una condicion de carrera puede provocar un interbloqueo", "f"),
			new Pregunta(
					"En un S.O. multiusuario los procesos de usuario no pueden inhubir las interrupciones pues podrian paralizar el sistema",
					"v"),
			new Pregunta(
					"El hardware de un sistema informatico no forma parte del S.O. que este utilizando dicho sistema",
					"v"),
			new Pregunta(
					"Los procesos de usuario no pueden tener acceso a los puertos de E/S del controlador de la impresora",
					"f"),
			new Pregunta("El comando ls mustra informacion sobre el contenido de un directorio", "v"),
			new Pregunta(
					"Un certificado digital es una credencial emitida por una autoridad de Certificacion 2023", "v"),
			new Pregunta("La compactacion se utiliza para eliminar la fragmentacion interna", "f"),
			new Pregunta(
					"Existen diferentes configuraciones en la conexion al bus del sistema de una controladora de Acceso Directo a Memoria (DMA)",
					"v"),
			new Pregunta(
					"Los puertos de E/S de los dispositivos que se utilizan en los ordenadores personales actuales se encuentran en memoria principal",
					"f"),
			new Pregunta("Un marco de pagina tiene exactamente el doble de tamaño que una pagina virtual", "f"),
			new Pregunta("El algoritmo del brazo del disco SSTF es el mas justo con todos los procesos", "f"),
			new Pregunta(
					"Un proceso que causa faltas de paginas cada pocas instrucciones se dice que se encuentra azotado",
					"v"),
			new Pregunta("Una tecnica para gestionar la E/S es a traves del uso de interrupciones", "v"),
			new Pregunta(
					"Cuando estamos construyendo un sistema operativo, las diferencias especificas de cada dispositivo se encapsulan en el software dependiente del dispositivo 2023",
					"f"),
			new Pregunta(
					"En los sistemas de archivos basados en nodo-i, los nombres de los archivos se almacenan en dichos nodos-i 2023",
					"f"),
			new Pregunta(
					"Un sistema de archivos tipo FAT utiliza listas encadenadas para gestionar los bloques asignados a los archivos",
					"v"),
			new Pregunta("El nombre de un dispoitivo lo proporciona el software de E/S dependiente del dispositivo",
					"f"),
			new Pregunta(
					"Los puertos de E/S son utilizados por el software de E/S dependiente del dispositivo de un sistema operativo",
					"v"),
			new Pregunta(
					"El algoritmo de envejecimiento (aging) es util para implementar una politica de carga de paginas anticipatoria",
					"v"),
			new Pregunta("Discos diferentes en un ordenador puede tener tamaños de sector diferentes", "v"),
			new Pregunta("La criptografia no permite que las comunicaciones puedan realizarse de forma segura", "f"),
			new Pregunta("El driver de un disco es el que determina el tamaño del bloque de dicho disco", "f"),
			new Pregunta("Los sistemas de encriptacion simetricos utilizan dos claves, una publica y otra privada",
					"f"),
			new Pregunta("Los dispositivos pueden tener diferentes tipos de errores", "v"),
			new Pregunta("¿Es cierto que los procesos solo pueden bloquearse debido a operaciones de E/S ? 2023", "f"),
			new Pregunta(
					"La confidencialidad asegura que los usuarios autorizados pueden acceder a la informacion cuando la necesitan 2023",
					"v"),
			new Pregunta("En el modo nucleo o supervisor de una CPU no es posible realizar operaciones de E/S ", "f"),
			new Pregunta(
					"El software de E/S independiente de los dispositivos tiene, entre sus funciones, proporcionar buffers a los dispositivos",
					"v"),
			new Pregunta("El disco duro es un dispositivo de tipo caracter", "f"),
			new Pregunta("Pueden estar ejecutándose más de un driver para el mismo dispositivo de E/S", "f"),
			new Pregunta(
					"El tiempo de búsqueda depende de la posición de la cabeza de lectura/grabación dentro de una pista",
					"f"),
			new Pregunta(
					"El algoritmo de planificación del brazo FCFS es aceptable cuando la carga de un disco es ligera",
					"v"),
			new Pregunta("Existe una parte del software de E/S que no pertenece al SO", "v"),
			new Pregunta(
					"Los controladores se comunican con la CPU mediante unos registros especiales que en algunos sistemas son direcciones de memoria",
					"v"),
			new Pregunta(
					"Los drivers son las unicas partes de un SO que conocen las peculiaridades de los dispositivos",
					"v"),
			new Pregunta("cuando el DMA esta ejecutandose, la CPU no puede acceder a la MP", "v"),
			new Pregunta("No es posible que se produzcan errores en los controladores de dispositivos", "f"),
			new Pregunta(
					"Los unicos factores que influyen en el acceso a disco son el tiempo de busqueda y el retraso rotacional",
					"v"),
			new Pregunta("Todos los perifericos trabajan con la misma representacion de los datos", "f"),
			new Pregunta(
					"El algoritmo SSF ('Shortest Seek First' ) de planificación del brazo del disco, en situaciones de cargas pesadas discrimina los cilindros externos",
					"f"),
			new Pregunta(
					"El software de E/S independiente de los dispositivos es el que establece mecanismos de protección en el acceso a los dispositivos",
					"v"),
			new Pregunta(
					"Las tecnicas de spooling permiten tratar dispositivos dedicados en sistemas de multiprogramacion",
					"v"),
			new Pregunta("Un archivo de lectura es un recurso compartible", "v"),
			new Pregunta("La compactacion se utiliza en los sistemas de memoria virtual (2023)", "f"),
			new Pregunta(
					"Un quantum (o intervalo de tiempo) es el tiempo asignado a un proceso para que se realice una operacion de E/S 2023",
					"f"),
			new Pregunta("Los hilos contienen solo una parte del codigo de un proceso 2023", "v"),
			new Pregunta(
					"Una operacion wait sobre un semaforo decrementa el valor de dicho semaforo si hay procesos bloqueados en la cola de dicho semaforo 2023",
					"f"),
			new Pregunta(
					"sd1 es el nombre de un dispositivo establecido por el software de E/S independiente del dispositivo 2023",
					"v"),
			new Pregunta("La funcion wait en la API System 5 hace lo mismo que la funcion semop en dicha API 2023",
					"f"),
			new Pregunta("Un marco de pagina siempre tiene el mismo tamaño que una pagina virtual 2023", "v"),
			new Pregunta("Los permisos de un archivo 660 son equivalentes a r--r----- 2023", "f"),
			new Pregunta("No se pueden crear 2 conjuntos de semaforos a la vez en la API System 5 2023", "v"),
			new Pregunta("El algoritmo del brazo del disco C-SCAN solo atiende peticiones en un unico sentido 2023",
					"v"),
			new Pregunta(
					"El paso de mensajes permite la comunicacion entre procesos que se encuentran en el mismo sistema informatico 2023",
					"f"),
			new Pregunta("La Disponibilidad asegura que la informacion estará siempre disponible 2023", "v"),
			new Pregunta("Una tuberia permite una comunicacion bidireccional 2023", "f"),
			new Pregunta(
					"Los sistemas de encriptacion asimetricos utilizan dos claves, una publica y otra privada 2023",
					"v"),
			new Pregunta(
					"Los sistemas informaticos actuales siguen utilizando las interrupciones como parte de la gestion de E/S 2023",
					"v"),
			new Pregunta(
					"En la API System 5 para poder usar un semaforo no es necesario previamente inicializarlo 2023",
					"f"),
			new Pregunta(
					"El comando du en Linux muestra información sobre los sistemas de archivos montados actualmente 2023",
					"f"),
			new Pregunta("En el modo nucleo o supervisor de una CPU, no es posible realizar operaciones de E/S 2023",
					"f"),
			new Pregunta("El permiso x en un directorio permite ejecutar dicho directorio 2023", "f"),
			new Pregunta("En la API System 5 para crear la memoria compartida se usa la funcion shmget 2023", "v"),
			new Pregunta(
					"Todos los discos duros que se pueden usar en un ordenador tienen el mismo tamaño de sector 2023",
					"f"),
			new Pregunta(
					"El algoritmo de sustitucion de paginas NRU asocia 2 bits (R y M) a cada pagina que se encuentra en un marco de pagina 2023",
					"v"),
			new Pregunta("En un script, el simbolo '|' se utiliza para representar una tuberia 2023", "v"),
			new Pregunta("El comando ls mustra informacion sobre el contenido de un archivo 2023", "f"),
			new Pregunta(
					"La funcion semop en la aPI System 5 se utiliza para hacer operaciones wait o signal sobre semaforos 2023 E",
					"v"),
			new Pregunta("sd es el nombre de un dispositivo de disco en Linux con interfaz SATA 2023 E", ""),
			new Pregunta("Los hilos de un proceso contienen todo el codigo de dicho proceso 2023 E", "f"),
			new Pregunta(
					"¿Es cierto que los procesos solo pueden bloquearse debido a operaciones con semáforos? 2023 E",
					"f"),
			new Pregunta(
					"La unidad de Gestion de memoria (MMU) transforma una direccion virtual en otra direccion virtual del mismo proceso 2023 E",
					"f"),
			new Pregunta(
					"El hardware de un sistema informatico forma parte del sistema operativo que esté utilizando dicho sistema 2023 E",
					"f"),
			new Pregunta(
					"La imagen de un proceso esta formada por la imagen de memoria de un proceso y los atributos de un proceso 2023 E",
					"v"),
			new Pregunta(
					"Existen mas factores que influyen en el acceso a disco aparte del tiempo de busqueda y del retraso rotacional",
					"f")

	};

	public static void main(String[] args) {
		System.out.println("Preguntas totales: " + preguntas.length);
		System.out.println();
		Set<Pregunta> preguntasMostradas = new HashSet<Pregunta>();
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		String respuesta = "hola";
		int bien = 0;
		int fallos = 0;
		int total = 0;
		double nota = 0;
		int num = 30;
		while (total < 30) {

			int pos = rand.nextInt(preguntas.length);
			// Se elige una pregunta al azar
			Pregunta pregunta = preguntas[rand.nextInt(preguntas.length)];
			if (!preguntasMostradas.contains(pregunta)) {

				System.out.println(pregunta.pregunta);
				System.out.println("Verdadero o falso? (V/F)");
				System.out.println("Pregunta " + (30 - num + 1));
				respuesta = sc.nextLine();

				if (respuesta.equals(pregunta.respuesta)) {
					System.out.println("--------------------------");
					System.out.println("|  Respuesta correcta    |");
					System.out.println("--------------------------");

					bien++;
				} else if (!respuesta.equals(pregunta.respuesta)) {
					System.out.println("--------------------------");
					System.out.println("|  Respuesta incorrecta  |");
					System.out.println("--------------------------");

					fallos++;
				}

				System.out.println();
				total++;
				preguntasMostradas.add(pregunta);
				num--;
			}

		}

		nota = (double) (bien - fallos) / total;
		nota *= 10;
		System.out.println("Bien: " + bien);
		System.out.println("Mal: " + fallos);
		System.out.println("Nota: " + nota);
	}
}
