import java.util.ArrayList;
import java.util.List;

public final class Pruebas {
    private static final List<Linea> COMPRA = List.of(
        new Linea("Cuaderno 200 hojas", 2, 275),
        new Linea("Calculadora científica", 1, 1450));

    private record Caso(String nombre, boolean paso) { }

    private static boolean igual(double a, double b) { return Math.abs(a - b) < 0.005; }

    public static void main(String[] args) {
        List<Caso> casos = new ArrayList<>();
        casos.add(new Caso("El subtotal suma cantidad por precio", igual(Precios.subtotal(COMPRA), 2000)));
        casos.add(new Caso("El ITBIS es el 18 % del subtotal", igual(Precios.impuesto(100), 18)));
        casos.add(new Caso("El resumen muestra el total", Reporte.resumen(COMPRA).contains("Total")));
        casos.add(new Caso("Descuento del 10 % en compras grandes", igual(Precios.descuento(20000), 2000)));
        casos.add(new Caso("Sin descuento en compras pequeñas", igual(Precios.descuento(100), 0)));

        int fallas = 0;
        for (Caso c : casos) {
            System.out.println((c.paso() ? "OK    " : "FALLA ") + c.nombre());
            if (!c.paso()) fallas++;
        }
        System.out.println(fallas == 0 ? "Todas las pruebas pasan." : fallas + " prueba(s) fallan.");
        System.exit(fallas == 0 ? 0 : 1);
    }
}
