import java.util.List;

public final class Reporte {
    private Reporte() { }

    public static String resumen(List<Linea> lineas) {
        double subtotal = Precios.subtotal(lineas);
        double impuesto = Precios.impuesto(subtotal);

        return String.format(
                java.util.Locale.ROOT,
                "Subtotal: %.2f | ITBIS: %.2f | Total: %.2f",
                subtotal,
                impuesto,
                subtotal + impuesto);
    }

    public static String resumenConEnvio(List<Linea> lineas) {
        double subtotal = Precios.subtotal(lineas);

        return resumen(lineas)
                + String.format(
                        java.util.Locale.ROOT,
                        " | Envío: %.2f",
                        Precios.cargoEnvio(subtotal));
    }
}