//: enumerated/Competitor.java
// Switching one enum on another.
package enumerated1;

public interface Competitor<T extends Competitor<T>> {
  Outcome compete(T competitor);
} ///:~
