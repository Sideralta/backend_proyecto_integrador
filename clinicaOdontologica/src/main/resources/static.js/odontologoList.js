window.addEventListener('load', function () {

    const odontologoContainer = document.querySelector("#odontologo-container");

        //invocamos utilizando la función fetch la API odontologos con el método POST que guardará
        //el odontologo que enviaremos en formato JSON
        const url = 'http://localhost:8082/odontologos';
        const settings = {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            }
        }

        fetch(url, settings)
        .then(response => response.json())
        .then(odontologos => {

          console.log(odontologos);

          renderizarOdontologos(odontologos);

        })
        .catch(err => console.log(err));

        function renderizarOdontologos(listado){
            listado.forEach(odontologo => {
                odontologoContainer.innerHTML +=`
                <div>
                <p>${odontologo.nombre}</p>
                <p>${odontologo.apellido}</p>
                <p>${odontologo.numeroMatricula}</p>
            </div>

                `
            });
        }



});