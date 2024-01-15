document.addEventListener("DOMContentLoaded", function () {
    let userThemePreference = localStorage.getItem('themePreference');

    if (userThemePreference === 'dark') {
        document.body.classList.add('dark-mode');
    }
});

function changeTheme() {
    document.body.classList.toggle('dark-mode');

    let newThemePreference = document.body.classList.contains('dark-mode') ? 'dark' : 'light';
    localStorage.setItem('themePreference', newThemePreference);
}

console.log("hello");