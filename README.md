--------------------------------------------------------------------------------------------
####Bienvenido a mi primer proyecto de JDBC
--------------------------------------------------------------------------------------------

Este es un proyecto que realice como parte del curso de Oracle One |Alura Latam en el que se procuró practicar todo lo aprendido en el curso de JDBC

######El proyecto consiste en un sistema de reservaciones y clientes de un Hotel y contaba con ciertos requisitos que son:

	- Un Acceso limitado por medio de usuario y contraseña.
	- Una ventana para elegir si buscar o registra.
	- Ventanas de Búsqueda.
	- Ventanas de Registro.
	- Botones de cerrar sesión.
	- Mensajes de alerta e información.

El programa inicia con una ventana de Bienvenida donde deberá presionar el botón “Ingresar”, de ahí pasara a la ventana de Acceso donde deberá ingresar un correo de empleado y la contraseña, de darse un ingreso correcto el sistema avisara con un mensaje y llevara al usuario a la ventana Elegir Acción, donde podrá elegir entre registrar una nueva reservación o buscar algún registro.

Si el usuario decide presionar el botor “Registrar”, ingresará a una ventana donde deberá registrar al cliente con su nombre completo, fecha de nacimiento y correo electrónico, al presionar registrar se generará un numero de cliente que nos servirá para relacionar con la reservación.

Una vez registrado el cliente se procederá a llenar los datos de la reservación como son fecha de entrada, fecha de salida y forma de pago, el sistema cargara automáticamente el numero de cliente desde la ventana de registrar cliente, y el número de reservación lo sacara según el ultimo registro de la base de datos.

De concretarse el registro el sistema informara con un mensaje de Registro Exitoso

Por otro lado, si en la ventana de elegir acción elegimos Búsqueda. Tendremos dos opciones más:
######Búsqueda de Reservaciones: en la que podremos busca- r 

	- Todas las reservaciones.
	- Por Numero de reservación.
	- Por Cliente.
	- Por Forma de pago.

######Búsqueda de Clientes: de igual manera podremos busca- r 

	- Todos los clientes.
	- Por Correo.
	- Por Numero de Cliente. 

Ambas ventanas cuentan con dos botones.

		Borrar: Esta opción al no poderse deshacer pregunta al usuario antes de efectuarse.
		Actualizar: Remite al usuario a una ventana similar al de registro ya sea de clientes 
		o reservaciones, para que ahí ajusten los datos que desean actualizar.

Por último, todas las ventanas cuentan con el botón de “Cerrar Sesión” y “Retroceder”

-----------------------------------------------------------------------------------
###Base de Datos MySQL
-----------------------------------------------------------------------------------
Para la base de datos se utilizo la plataforma de MySQL, creando 3 tablas.

######Empleados

	Id int AI PK 
	Registro timestamp 
	CorreoUsuario varchar(50) 
	PasswordUsuario varchar(20)

######Reservaciones
	Id int AI PK 
	Registro timestamp 
	FechaEntrada date 
	FechaSalida date 
	FormaDePago varchar(30) 
	Dias int 
	Total double 
	NumReservacion varchar(30) 
	Cliente int

######Clientes
	Id int AI PK 
	Registro timestamp 
	Nombre varchar(30) 
	Apellido varchar(30) 
	FNacimiento date 
	Correo varchar(50)


En el caso del cliente se utilizó como valor único el correo electrónico, por lo que de ser repetido no registra al cliente y solo arroja un mensaje de bienvenida al cliente.

Como verán es un proyecto muy sencillo pero que fue muy importante para aplicar lo aprendido en clase.
