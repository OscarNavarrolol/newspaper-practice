document.addEventListener('DOMContentLoaded', () => {
    fetch('http://localhost:8083/api_new/get_user')
        .then(response => response.json())
        .then(data => {
            const articlesSection = document.getElementById('articles');

            data.forEach(article => {
                const articleElement = document.createElement('article');
                articleElement.classList.add('article');

                const titleElement = document.createElement('h3');
                titleElement.classList.add('articleTitle');
                titleElement.textContent = article.title;

                const contentElement = document.createElement('p');
                contentElement.classList.add('articleBody');
                contentElement.textContent = article.content;

                const dateElement = document.createElement('p');
                dateElement.classList.add('articleDate');
                dateElement.textContent = new Date(article.publicationDate).toDateString();

                articleElement.appendChild(titleElement);
                articleElement.appendChild(contentElement);
                articleElement.appendChild(dateElement);

                articlesSection.appendChild(articleElement);
            });
        })
        .catch(error => console.error('Error fetching data:', error));
});