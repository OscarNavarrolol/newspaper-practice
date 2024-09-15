document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('.my-login-validation');

    form.addEventListener('submit', function(event) {
        event.preventDefault();

        const name = document.getElementById('name').value;
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;
        const agree = document.getElementById('agree').checked;

        if (!agree) {
            alert("ACEPTA LOS TERMINOS EL DIABLO")
            const invalidFeedback = document.querySelector('#agree ~ .invalid-feedback');
            invalidFeedback.style.display = 'block';
            return;
        }

        const user = {
            userName: name,
            email: email,
            password: password
        };

        fetch('http://localhost:8083/api_user/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(user)
        })
            .then(response => response.json())
            .then(data => {
                console.log('Success:', data);
                window.location.href = '/user/v1'; // Cambia esto según tu estructura de rutas
            })
            .catch(error => {
                console.error('Error:', error);
                alert('Registration failed. Please try again.');
            });
    });

    const emailField = document.getElementById('email');
    emailField.addEventListener('input', function(event) {
        if (!emailField.validity.valid) {
            emailField.setCustomValidity('Please enter a valid email address.');
        } else {
            emailField.setCustomValidity('');
        }
    });
});
