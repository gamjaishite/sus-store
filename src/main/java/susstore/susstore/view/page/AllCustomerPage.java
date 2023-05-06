package susstore.susstore.view.page;

import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import susstore.susstore.view.PageType;
import susstore.susstore.view.component.CustomerCardComponent;
import susstore.susstore.view.component.JoinDataTest;

public class AllCustomerPage extends Page {
    private final SplitPane pageRootLayout;
    private final JoinDataTest joinDataTest;

    public AllCustomerPage(JoinDataTest joinDataTest) {
        super(PageType.AllCustomerPage);
        this.pageRootLayout = new SplitPane();
        this.joinDataTest = joinDataTest;
        loadUI();
        setStylesheet();
        this.tab.setContent(this.pageRootLayout);
    }

    private void loadUI() {
        VBox customersContainer = new VBox();
        for (int i = 0; i < 20; i++) {
            CustomerCardComponent card = new CustomerCardComponent();
            customersContainer.getChildren().add(card.getComponent());
        }
        customersContainer.getStyleClass().add("customers-container-all-customer");

        ScrollPane customersContainerScroll = new ScrollPane();
        customersContainerScroll.setContent(customersContainer);
        customersContainerScroll.setFitToWidth(true);

        Label nameLabel = new Label("Name:");
        TextField nameInput = new TextField();
        VBox nameContainer = new VBox();
        nameLabel.getStyleClass().add("input-label-all-customer");
        nameInput.getStyleClass().add("input-all-customer");
        nameContainer.getChildren().addAll(nameLabel, nameInput);

        Label phonNumberLabel = new Label("Phone Number:");
        TextField phoneNumberInput = new TextField();
        VBox phoneNumberContainer = new VBox();
        phonNumberLabel.getStyleClass().add("input-label-all-customer");
        phoneNumberInput.getStyleClass().add("input-all-customer");
        phoneNumberContainer.getChildren().addAll(phonNumberLabel, phoneNumberInput);

        Label membershipLabel = new Label("Membership:");
        ChoiceBox membershipChoices = new ChoiceBox();
        membershipChoices.getItems().add("VIP");
        membershipChoices.getItems().add("MEMBER");
        VBox membershipInputContainer = new VBox();
        membershipLabel.getStyleClass().add("input-label-all-customer");
        membershipChoices.getSelectionModel().selectFirst();
        membershipInputContainer.getChildren().addAll(membershipLabel, membershipChoices);

        Label statusLabel = new Label("Status:");
        ChoiceBox statusChoices = new ChoiceBox();
        statusChoices.getItems().add("ACTIVE");
        statusChoices.getItems().add("DISABLED");
        VBox statusInputContainer = new VBox();
        statusLabel.getStyleClass().add("input-label-all-customer");
        statusChoices.getSelectionModel().selectFirst();
        statusInputContainer.getChildren().addAll(statusLabel, statusChoices);

        BorderPane membershipAndStatusContainer = new BorderPane();
        membershipAndStatusContainer.setLeft(membershipInputContainer);
        membershipAndStatusContainer.setRight(statusInputContainer);
//        membershipAndStatusContainer.getChildren().addAll(membershipInputContainer, statusInputContainer);
        membershipAndStatusContainer.getStyleClass().add("membership-status-container-all-customer");

        VBox formContainer = new VBox();
        formContainer.getStyleClass().add("form-container-all-customer");
        formContainer.getChildren().addAll(nameContainer, phoneNumberContainer, membershipAndStatusContainer);

        Button cancelButton = new Button("Cancel");
        Button saveButton = new Button("Save");
        HBox actionButtonsContainer = new HBox();
        cancelButton.getStyleClass().addAll("action-button-all-customer", "cancel-button-all-customer");
        saveButton.getStyleClass().addAll("action-button-all-customer", "save-button-all-customer");
        actionButtonsContainer.getStyleClass().add("action-buttons-container-all-customer");
        actionButtonsContainer.getChildren().addAll(cancelButton, saveButton);

        saveButton.setOnAction(event -> {
            System.out.println(nameInput.getText());
            this.joinDataTest.setName(nameInput.getText());
        });

        BorderPane formAndActionsContainer = new BorderPane();
        formAndActionsContainer.setCenter(formContainer);
        formAndActionsContainer.setBottom(actionButtonsContainer);
        formAndActionsContainer.getStyleClass().add("form-actions-container-all-customer");

        this.pageRootLayout.setDividerPositions(0.65, 0.35);
        this.pageRootLayout.getItems().addAll(customersContainerScroll, formAndActionsContainer);
    }


    private void setStylesheet() {
        this.pageRootLayout.getStyleClass().add("page-root-layout");
        this.pageRootLayout.getStylesheets().add("css/all-customer-page.css");
    }
}
