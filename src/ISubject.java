// Observer Pattern - Abstract Subject
// Implemented in Sprint 4
public interface ISubject {
    void attach(IObserver observer);
    void detach(IObserver observer);
    void notifyObservers();
}
