document.addEventListener('DOMContentLoaded', function() {
    // Simulación de carga de noticias desde una fuente externa (por ejemplo, una API)
    const newsGrid = document.getElementById('news-grid');

    // Datos simulados de noticias
    const noticias = [
        { titulo: 'Título de la Noticia 1', descripcion: 'Descripción breve de la noticia 1.' },
        { titulo: 'Título de la Noticia 2', descripcion: 'Descripción breve de la noticia 2.' },
        { titulo: 'Título de la Noticia 3', descripcion: 'Descripción breve de la noticia 3.' },
        { titulo: 'Título de la Noticia 4', descripcion: 'Descripción breve de la noticia 4.' }
        // Puedes añadir más noticias aquí
    ];

    // Función para crear elementos de noticias
    function mostrarNoticias() {
        noticias.forEach(noticia => {
            const newsItem = document.createElement('div');
            newsItem.classList.add('news-item');

            const titulo = document.createElement('h3');
            titulo.textContent = noticia.titulo;

            const descripcion = document.createElement('p');
            descripcion.textContent = noticia.descripcion;

            const leerMas = document.createElement('a');
            leerMas.href = '#';
            leerMas.textContent = 'Leer más';
            leerMas.classList.add('read-more');

            newsItem.appendChild(titulo);
            newsItem.appendChild(descripcion);
            newsItem.appendChild(leerMas);

            newsGrid.appendChild(newsItem);
        });
    }

    // Llamar a la función para mostrar las noticias
    mostrarNoticias();
});
