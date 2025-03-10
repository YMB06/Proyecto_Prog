document.addEventListener('DOMContentLoaded', function() {
    const cocheSelect = document.getElementById('coche');
    const fechaInicio = document.getElementById('fecha_inicio');
    const fechaFin = document.getElementById('fecha_fin');
    const precioTotal = document.getElementById('precio_total');
    const cochesDataDiv = document.getElementById('cochesData');

    // Get cars data from the hidden div
    const cochesData = JSON.parse(cochesDataDiv.getAttribute('data-coches-json'));
    const precios = {};

    // Create a map of car IDs to their daily prices
    cochesData.forEach(coche => {
        precios[coche.id] = parseFloat(coche.precio);
        console.log(`Car ID: ${coche.id}, Price: ${coche.precio}`);
    });

    function calcularPrecioTotal() {
        const cocheId = cocheSelect.value;
        const inicio = new Date(fechaInicio.value);
        const fin = new Date(fechaFin.value);

        if (cocheId && fechaInicio.value && fechaFin.value) {
            const diferencia = fin.getTime() - inicio.getTime();
            const dias = Math.ceil(diferencia / (1000 * 3600 * 24));
            const precioPorDia = precios[cocheId];

            if (dias > 0 && precioPorDia) {
                const total = (dias * precioPorDia).toFixed(2);
                precioTotal.value = total;
                console.log(`Days: ${dias}, Daily price: ${precioPorDia}, Total: ${total}`);
            }
        }
    }

    // Add event listeners
    cocheSelect.addEventListener('change', calcularPrecioTotal);
    fechaInicio.addEventListener('change', calcularPrecioTotal);
    fechaFin.addEventListener('change', calcularPrecioTotal);

    // Calculate initial price if editing
    if (cocheSelect.value && fechaInicio.value && fechaFin.value) {
        calcularPrecioTotal();
    }
});