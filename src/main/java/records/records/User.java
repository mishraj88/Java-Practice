package records;

// default simple record with final fields
// java will generate canonical constructors for this record, which looks as below
/*
public User (String name, int age) {
this.name = name;
this.age = age;
}
*/

/**
 * the toString() and hashCode() functions are available from base class Record
 */
public record User(String name, int age) {

}
