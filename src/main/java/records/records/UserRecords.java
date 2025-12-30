
package records;


//by default records are immutable -> all fields are final
// records are meant for data carrier -> so can be used as DTOs

// since records are immutable at language level -> they have no setters - and they have only canonical constructors available

//cannonical constructors -> default parameterised constructors


public record UserRecords(String name, int age) {

   // to add custom validations you can use following compact constructor
   // compact constructors are used for validation and data modification before the canonical constructor
   // is called


   // compact constructor -> for validations and data modification
   public UserRecords {
    if(age < 0)
        throw new IllegalArgumentException("Invalid age. Age must be greater than zero");

    name = name.toLowerCase().trim();
   }

   //explicit constructor -> for overloading the canonical constructor- which internally calls the canonical constructor
   public UserRecords(String name){
      this(name, 0);
   }

   /*
   * this creates constructor like this post compilation
   public UserRecords(String name, int age){

      if(age <= 0){
         throw new IllegalArguementException("Invalid age. Age must be greater than zero")
      }
      else{
         name = name.toLowerCase().trim();

      this.name = name;
      this.age = age;
         }
      
   }
   
   public UserRecords(String name) {

      this(name, 0);
   }
    */

}
