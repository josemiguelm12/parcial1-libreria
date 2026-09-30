import java.util.List;

public final class Precios {
    public static final double MONTO_MINIMO_DESCUENTO = 2500;

    public static final double ITBIS = 0.18;

    private Precios() { }

    // Suma cantidad por precio unitario de cada línea.
    public static double calcularSubtotal(List<Linea> lineas) {
        return lineas.stream().mapToDouble(l -> l.cantidad() * l.precioUnitario()).sum();
    }

    public static double impuesto(double subtotal) {
        return Math.round(subtotal * ITBIS * 100.0) / 100.0;
    }
}
