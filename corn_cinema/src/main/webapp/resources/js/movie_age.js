window.onload = function () {
    function age() {
        var age = document.querySelectorAll(".age-ico");
        for(index in age){
           console.log(age[index]);
           if (age[index].innerHTML === "전체 관람가") {
                age[index].classList.add('age-all');
            }
              else if (age[index].innerHTML === "12세 이상 관람가") {
                age[index].classList.add('age-12');
            }
            else if (age[index].innerHTML === "15세 이상 관람가") {
                age[index].classList.add('age-15');
            }
            else{
                age[index].classList.add('age-19');
            }
        }
        /*for(var i = 0; i<age.length;i++){
           if (age[i].innerHTML === "전체 관람가") {
                age[i].classList.add('age-all');
            }
              else if (age[i].innerHTML === "12세 이상 관람가") {
                age[i].classList.add('age-12');
            }
            else if (age[i].innerHTML === "15세 이상 관람가") {
                age[i].classList.add('age-15');
            }
            else{
                age[i].classList.add('age-19');
            }
        }*/
        /*age.forEach(function (age) {
           if (age.innerHTML === "전체 관람가") {
                age.classList.add('age-all');
            }
           else if (age.innerHTML === "12세 이상 관람가") {
                age.classList.add('age-12');
            }
            else if (age.innerHTML === "15세 이상 관람가") {
                age.classList.add('age-15');
            }
            else{
                age.classList.add('age-19');
            }
        })*/
    }
    age();
}