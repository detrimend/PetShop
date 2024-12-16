$.get("xml/AnimalsForSaleList.xml", handleContent);
    function handleContent(xml){

    let animals = $(xml).find("animals")
 
        let result= "";
        for(let animal of animals)
             {
                let animalInfo = $(animal).find("animalInfo")


                result += "Race: " + $(animal).find("animalType").text() + "<br>" + "Alder: " +$(animal).find("age").text() + "<br>" 
                + "Art:" + animalInfo.find("species").text() + "<br>" +"Køn: " ;
                if(animalInfo.find("gender").text()=="m"||animalInfo.find("gender").text()=="M" )  {
                    result += "Han" + "<br>"
                }
                else{
                    result += "Hun" +"<br>"
                }
                result+= "Pris" + $(animal).find("price").text() + " DKK" + "<br>"
                if($(animal).find("isForSale").text()=="true")
                {
                    result+= "Status: Åben for reservation"
                }

            }
            $("#textField2").html(result);
    
        } 

$.get("xml/AnimalsForSaleList.xml", handleContent);

function handleContent(xml) {
    let animals = $(xml).find("animals");
    let result = "<div class='container'><div class='row'>"; // Start the Bootstrap container and row

    for (let animal of animals) {
        let animalInfo = $(animal).find("animalInfo");
        let animalType = $(animal).find("animalType").text();
        let age = $(animal).find("age").text();
        let species = animalInfo.find("species").text();
        let gender = animalInfo.find("gender").text();
        let price = $(animal).find("price").text();
        let isForSale = $(animal).find("isForSale").text();

        // Determine the gender in Danish
        let genderText = (gender.toLowerCase() === "m") ? "Han" : "Hun";
        let status = (isForSale === "true") ? "Åben for salg" : "Ikke tilgængelig";

        // Add a Bootstrap card for each animal
        result += `
            <div id="kasser" class= 'col-12 col-md-6 col-lg-4 image-container mt-4'>
                <div class='card'>
                    <div class='card-body'>
                        <h5 class='card-title'>Race: ${animalType}</h5>
                        <p class='card-text'>
                            Alder: ${age}<br>
                            Art: ${species}<br>
                            Køn: ${genderText}<br>
                            Pris: ${price} DKK<br>
                            Status: ${status}
                        </p>
                    </div>
                </div>
            </div>
        `;
    }

    result += "</div></div>"; // Close the Bootstrap row and container
    $("#textField2").html(result); // Inject the generated content into the specified element
}
