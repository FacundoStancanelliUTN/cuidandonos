Integrante: Facundo Diego Stancanelli

"# cuidandonos" 
![Cuidandonos](https://github.com/FacundoStancanelliUTN/cuidandonos/assets/129307586/cd5ae1e5-1774-40f9-8394-70d92db93259)



Se utilizan los siguientes patrones de diseño:

Strategy: Se utiliza por ejemplo en las reacciones, debido a que dice que el usuario podria cambiar la forma de reaccionar, y todas las clases tienen un metodo en comun llamado "reaccionar()"

Adapter: Se utiliza por ejemplo en el CalculadorDistanciaEntreDirecciones, ya que el enunciado detalla que se utiliza una API de Google, pero como desconocemos su implementacion y sus firmas para calcular una distancia dadas dos direcciones, definimos una interfaz donde detallamos que es lo que necesitamos conseguir en nuestro modelo, abstrayendonos de la implementacion de la api y delegando responsabilidades.
