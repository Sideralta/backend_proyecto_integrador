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
        if(listado.length == 0){
                        odontologoContainer.innerHTML = `
                        <div>
                        <p>No hay odontologos registrados</p>
                    </div>
                        `;
                    }
            listado.forEach(odontologo => {
                odontologoContainer.innerHTML +=`
                <div class="card-header">
                <p>Nombre: ${odontologo.nombre}</p>
                <hr>
                <p>Apellido: ${odontologo.apellido}</p>
                <hr>
                <p>Matricula: ${odontologo.numeroMatricula}</p>
            </div>

                `
            });
        }



});