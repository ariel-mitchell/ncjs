import React, { useState, useEffect } from 'react';

function App() {
  const [locations, setLocations] = useState([]);
  const [newLocation, setNewLocation] = useState('');

  useEffect(() => {
    fetch('/api/locations')
      .then(response => response.json())
      .then(data => setLocations(data));
  }, []);

  const handleAddLocation = () => {
    fetch('/api/locations', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ name: newLocation }),
    })
      .then(response => response.json())
      .then(data => setLocations([...locations, data]));

    setNewLocation('');
  };

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