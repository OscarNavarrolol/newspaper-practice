document.addEventListener('DOMContentLoaded', () => {
    fetch('http://localhost:8083/api_new/get_new')
        .then(response => response.json())
        .then(data => {
            const articlesSection = document.getElementById('articles');
            articlesSection.innerHTML = '';

            const articlesToShow = data.slice(0, 3);

            articlesToShow.forEach(article => {
                const articleElement = document.createElement('article');
                articleElement.classList.add('article');

                const titleElement = document.createElement('h3');
                titleElement.classList.add('articleTitle');
                titleElement.innerHTML = article.title;

                const contentElement = document.createElement('p');
                contentElement.classList.add('articleBody');
                contentElement.textContent = article.content;

                const dateElement = document.createElement('p');
                dateElement.classList.add('articleDate');
                dateElement.textContent = new Date(article.publicationDate).toDateString();

                articleElement.appendChild(titleElement);
                articleElement.appendChild(contentElement);
                articleElement.appendChild(dateElement);

                if (article.imageUrl) {
                    const figureElement = document.createElement('figure');
                    figureElement.classList.add('articleImage');

                    const imgElement = document.createElement('img');
                    imgElement.src = article.imageUrl;
                    imgElement.alt = article.title;

                    figureElement.appendChild(imgElement);
                    articleElement.appendChild(figureElement);
                }

                articlesSection.appendChild(articleElement);
            });
        })
        .catch(error => console.error('Error fetching data:', error));
});
