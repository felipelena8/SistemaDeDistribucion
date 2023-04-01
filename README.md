## SistemaAdministracion
 Sistema en el que el cliente realiza pedidos y se le asignara a los repartidores segun sea su zona de trabajo

# Diagrama de clases
![Diagrama de clases](Images\Ej1.png)

# Logica de Zonas

Una zona esta compuesta por cuatro coordenadas, las cuales establecen las esquinas superiores izquierda y derecha y las esquinas inferiores izquierda y derecha. Si se trazan las rectas de manera adyacente, se podria delimitar la zona formando un cuadrilatero.

![Zonas formadas por rectas](Images\Zonas.png)

Para saber si una direccion se encuentra en la zona, se deben trazar 4 rectas salientes del punto en los sentidos: arriba, abajo, derecha e izquierda hasta intersecar con los lados del cuadrilatero.

![Rectas trazadas en el cuadrilatero](Images\logicaZonas.png)

Si la coordenada del pedido se mantiene entre la interseccion de la recta derecha y la interseccion de la recta izquierda con el cuadrilatero y tambien se ubica entre la interseccion de la recta hacia arriba y la interseccion de la recta hacia abajo con el cuadrilatero, entonces esa direccion se ubica en la zona.
