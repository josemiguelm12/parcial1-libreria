public record Linea(String producto, int cantidad, double precioUnitario) {
    public Linea {
        if (cantidad <= 0) {
            throw new IllegalArgumentException(
                    "La cantidad debe ser mayor que cero.");
        }
    }
}