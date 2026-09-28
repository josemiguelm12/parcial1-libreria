import java.util.List;

public final class Reporte {
    private Reporte() { }

    public static String resumen(List<Linea> lineas) {
        double subtotal = Precios.calcularSubtotal(lineas);
        double impuesto = Precios.impuesto(subtotal);
        return String.format(java.util.Locale.ROOT, "Subtotal: %.2f | ITBIS: %.2f | Total: %.2f", subtotal, impuesto, subtotal + impuesto);
    }
}
