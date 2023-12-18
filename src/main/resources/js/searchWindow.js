const addButton = document.getElementById('addButton');
const modalOverlay = document.getElementById('modalOverlay');
const locationModal = document.getElementById('locationModal');

addButton.addEventListener('click', openModal);

function openModal() {
    modalOverlay.style.display = 'block';
    locationModal.style.display = 'block';
}

function closeModal() {
    modalOverlay.style.display = 'none';
    locationModal.style.display = 'none';
}