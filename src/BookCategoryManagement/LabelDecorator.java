package src.BookCategoryManagement;

public class LabelDecorator extends BookDecorator{
    private String label;

    public LabelDecorator(BookComponent decoratedBook, String label) {
        super(decoratedBook);
        this.label = label;
    }

    @Override
    public void showDetails() {
        decoratedBook.showDetails();
        System.out.println("Label: " + label);
    }
}
