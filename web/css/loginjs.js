/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
            
             function fun(form)
             {
               
                const u="sakshi";
                const pas="sakshi";
                const usern=form.userid.value;
                const passw=form.passw.value;
               
                if(usern== u && passw == pas)
                {
                  alert("Succesfully Login");
                }
               else
               {
                 alert("Error Password or Username");/*displays error message*/
                }
                document.write("<html><body>hii</body></html>");
               
            }
          

