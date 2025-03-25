document.getElementById('processBtn').addEventListener('click', async () => {
    const fileInput = document.getElementById('imageInput');
    if (!fileInput.files.length) {
        alert("Veuillez sélectionner une image !");
        return;
    }

    const formData = new FormData();
    formData.append("file", fileInput.files[0]);

    try {
        const response = await fetch("http://localhost:8080/conv/fr", {
            method: "POST",
            body: formData
        });

        if (!response.ok) {
            throw new Error("Erreur lors de l'extraction du texte");
        }

        const text = await response.text();
        document.getElementById('outputText').textContent = text;
    } catch (error) {
        console.error("Erreur OCR :", error);
        alert("Impossible d'extraire le texte !");
    }
});