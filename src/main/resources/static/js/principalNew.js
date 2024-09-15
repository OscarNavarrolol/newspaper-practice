document.addEventListener('DOMContentLoaded', () => {
    fetch('http://localhost:8083/api_new/recent')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok ' + response.statusText);
            }
            return response.json();
        })
        .then(data => {
            updateNewsContent(data);
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
});

function updateNewsContent(news) {
    const titleElement = document.getElementById('news-title');
    const dateElement = document.getElementById('news-date');
    const contentElement = document.getElementById('news-content');

    titleElement.textContent = news.title;
    dateElement.textContent = formatDate(news.publicationDate);
    dateElement.setAttribute('datetime', news.publicationDate);
    contentElement.textContent = news.content;
}

function formatDate(dateString) {
    const options = { year: 'numeric', month: 'long', day: 'numeric' };
    const date = new Date(dateString);
    return date.toLocaleDateString('es-ES', options);
}
