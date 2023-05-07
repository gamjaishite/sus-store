package susstore.susstore.view.component;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class CustomerCardComponent {
    private final BorderPane componentRootLayout;
    private final VBox idAndMembershipContainer;
    private final HBox statusAndActionsContainer;
    private final VBox nameAndPhoneContainer;

    public CustomerCardComponent() {
        this.componentRootLayout = new BorderPane();
        this.idAndMembershipContainer = new VBox();
        this.statusAndActionsContainer = new HBox();
        this.nameAndPhoneContainer = new VBox();
        loadUI();
    }

    private void loadUI() {
        // left
        Label membershipLabel = new Label("VIP");
        membershipLabel.getStyleClass().add("membership-label");
        Label idLabel = new Label("999999");
        idLabel.getStyleClass().add("id-label");

        this.idAndMembershipContainer.getChildren().addAll(membershipLabel, idLabel);

        // center
        Label nameLabel = new Label("Kurokawa Akane");
        Label phonNumberLabel = new Label("09098309");
        nameLabel.getStyleClass().add("name-label");
        phonNumberLabel.getStyleClass().add("phone-number-label");

        this.nameAndPhoneContainer.getChildren().addAll(nameLabel, phonNumberLabel);

        // right
        Button deleteButton = new Button("\uf2ed;");
        Button editButton = new Button("\uf4ff;");
        deleteButton.getStyleClass().add("delete-action-button");
        editButton.getStyleClass().add("edit-action-button");

        Label statusLabel = new Label("ACTIVE");
        Label transactionLabel = new Label("99999 transactions");
        statusLabel.getStyleClass().addAll("status-label", "status-label-active");
        transactionLabel.getStyleClass().add("transaction-label");

        VBox statusAndTransactionContainer = new VBox();
        statusAndTransactionContainer.getChildren().addAll(statusLabel, transactionLabel);
        statusAndTransactionContainer.getStyleClass().add("status-transaction-container");

        this.statusAndActionsContainer.getChildren().addAll(statusAndTransactionContainer, editButton, deleteButton);


        // root layout
        this.componentRootLayout.setLeft(this.idAndMembershipContainer);
        this.componentRootLayout.setRight(this.statusAndActionsContainer);
        this.componentRootLayout.setCenter(this.nameAndPhoneContainer);

        // stylesheet
        setStyleSheet();
    }

    private void setStyleSheet() {
        this.idAndMembershipContainer.getStyleClass().add("id-membership-container");
        this.statusAndActionsContainer.getStyleClass().add("status-actions-container");
        this.nameAndPhoneContainer.getStyleClass().add("name-phone-container");
        this.componentRootLayout.getStyleClass().add("root-component-layout");
        this.componentRootLayout.getStylesheets().add("css/customer-card-component.css");
    }

    public Pane getComponent() {
        return this.componentRootLayout;
    }
}