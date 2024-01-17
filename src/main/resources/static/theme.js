function updateButtonText() {
    let themeButton = document.getElementById('theme-change');
    if (document.body.classList.contains('dark-mode')) {
        themeButton.textContent = 'Light Mode';
    } else {
        themeButton.textContent = 'Dark Mode';
    }
}

document.addEventListener("DOMContentLoaded", function () {
    let userThemePreference = localStorage.getItem('themePreference');

    if (userThemePreference === 'dark') {
        document.body.classList.add('dark-mode');
    }

    updateButtonText();

    function changeTheme() {
        document.body.classList.toggle('dark-mode');
        updateButtonText();

        let newThemePreference = document.body.classList.contains('dark-mode') ? 'dark' : 'light';
        localStorage.setItem('themePreference', newThemePreference);
    }

    let themeButton = document.getElementById('theme-change');
    if (themeButton) {
        themeButton.addEventListener('click', changeTheme);
    }
});


window.updateButtonText = updateButtonText;
