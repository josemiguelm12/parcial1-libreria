import java.util.List;

public final class Precios {
    public static final double MONTO_MINIMO_DESCUENTO = 1200;

    public static final double ITBIS = 0.18;

    private Precios() { }

    // Suma cantidad por precio unitario de cada línea.
    public static double subtotal(List<Linea> lineas) {
        return lineas.stream().mapToDouble(l -> l.cantidad() * l.precioUnitario()).sum();
    }

    public static double impuesto(double subtotal) {
        return Math.round(subtotal * ITBIS * 100.0) / 100.0;
    }

    public static double descuento(double subtotal) {
        return subtotal >= MONTO_MINIMO_DESCUENTO
            ? Math.round(subtotal * 10) / 100.0
            : 0;
    }
}