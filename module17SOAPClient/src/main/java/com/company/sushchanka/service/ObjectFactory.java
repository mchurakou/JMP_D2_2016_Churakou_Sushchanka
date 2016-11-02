
package com.company.sushchanka.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.company.sushchanka.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SaveUserResponse_QNAME = new QName("http://service.sushchanka.company.com/", "saveUserResponse");
    private final static QName _FindAllUsers_QNAME = new QName("http://service.sushchanka.company.com/", "findAllUsers");
    private final static QName _UpdateUserTaskResponse_QNAME = new QName("http://service.sushchanka.company.com/", "updateUserTaskResponse");
    private final static QName _SaveUser_QNAME = new QName("http://service.sushchanka.company.com/", "saveUser");
    private final static QName _UpdateUserResponse_QNAME = new QName("http://service.sushchanka.company.com/", "updateUserResponse");
    private final static QName _FindTaskByName_QNAME = new QName("http://service.sushchanka.company.com/", "findTaskByName");
    private final static QName _DeleteTaskOfUserByIdResponse_QNAME = new QName("http://service.sushchanka.company.com/", "deleteTaskOfUserByIdResponse");
    private final static QName _FindById_QNAME = new QName("http://service.sushchanka.company.com/", "findById");
    private final static QName _SaveTask_QNAME = new QName("http://service.sushchanka.company.com/", "saveTask");
    private final static QName _FindByNameResponse_QNAME = new QName("http://service.sushchanka.company.com/", "findByNameResponse");
    private final static QName _FindAllUserTasks_QNAME = new QName("http://service.sushchanka.company.com/", "findAllUserTasks");
    private final static QName _DeleteUserByIdResponse_QNAME = new QName("http://service.sushchanka.company.com/", "deleteUserByIdResponse");
    private final static QName _DeleteAllUserTasks_QNAME = new QName("http://service.sushchanka.company.com/", "deleteAllUserTasks");
    private final static QName _FindUserTaskByIdTask_QNAME = new QName("http://service.sushchanka.company.com/", "findUserTaskByIdTask");
    private final static QName _DeleteAllUsersResponse_QNAME = new QName("http://service.sushchanka.company.com/", "deleteAllUsersResponse");
    private final static QName _FindAllUsersResponse_QNAME = new QName("http://service.sushchanka.company.com/", "findAllUsersResponse");
    private final static QName _FindUserTaskByIdTaskResponse_QNAME = new QName("http://service.sushchanka.company.com/", "findUserTaskByIdTaskResponse");
    private final static QName _DeleteUserById_QNAME = new QName("http://service.sushchanka.company.com/", "deleteUserById");
    private final static QName _User_QNAME = new QName("http://service.sushchanka.company.com/", "user");
    private final static QName _DeleteTaskOfUserById_QNAME = new QName("http://service.sushchanka.company.com/", "deleteTaskOfUserById");
    private final static QName _IsTaskExist_QNAME = new QName("http://service.sushchanka.company.com/", "isTaskExist");
    private final static QName _SaveTaskResponse_QNAME = new QName("http://service.sushchanka.company.com/", "saveTaskResponse");
    private final static QName _DeleteAllUsers_QNAME = new QName("http://service.sushchanka.company.com/", "deleteAllUsers");
    private final static QName _FindByIdResponse_QNAME = new QName("http://service.sushchanka.company.com/", "findByIdResponse");
    private final static QName _FindByName_QNAME = new QName("http://service.sushchanka.company.com/", "findByName");
    private final static QName _UpdateUser_QNAME = new QName("http://service.sushchanka.company.com/", "updateUser");
    private final static QName _FindTaskByNameResponse_QNAME = new QName("http://service.sushchanka.company.com/", "findTaskByNameResponse");
    private final static QName _IsUserExist_QNAME = new QName("http://service.sushchanka.company.com/", "isUserExist");
    private final static QName _IsTaskExistResponse_QNAME = new QName("http://service.sushchanka.company.com/", "isTaskExistResponse");
    private final static QName _FindAllUserTasksResponse_QNAME = new QName("http://service.sushchanka.company.com/", "findAllUserTasksResponse");
    private final static QName _IsUserExistResponse_QNAME = new QName("http://service.sushchanka.company.com/", "isUserExistResponse");
    private final static QName _UpdateUserTask_QNAME = new QName("http://service.sushchanka.company.com/", "updateUserTask");
    private final static QName _DeleteAllUserTasksResponse_QNAME = new QName("http://service.sushchanka.company.com/", "deleteAllUserTasksResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.company.sushchanka.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteAllUserTasks }
     * 
     */
    public DeleteAllUserTasks createDeleteAllUserTasks() {
        return new DeleteAllUserTasks();
    }

    /**
     * Create an instance of {@link FindUserTaskByIdTask }
     * 
     */
    public FindUserTaskByIdTask createFindUserTaskByIdTask() {
        return new FindUserTaskByIdTask();
    }

    /**
     * Create an instance of {@link DeleteUserByIdResponse }
     * 
     */
    public DeleteUserByIdResponse createDeleteUserByIdResponse() {
        return new DeleteUserByIdResponse();
    }

    /**
     * Create an instance of {@link FindAllUserTasks }
     * 
     */
    public FindAllUserTasks createFindAllUserTasks() {
        return new FindAllUserTasks();
    }

    /**
     * Create an instance of {@link DeleteTaskOfUserByIdResponse }
     * 
     */
    public DeleteTaskOfUserByIdResponse createDeleteTaskOfUserByIdResponse() {
        return new DeleteTaskOfUserByIdResponse();
    }

    /**
     * Create an instance of {@link SaveTask }
     * 
     */
    public SaveTask createSaveTask() {
        return new SaveTask();
    }

    /**
     * Create an instance of {@link FindByNameResponse }
     * 
     */
    public FindByNameResponse createFindByNameResponse() {
        return new FindByNameResponse();
    }

    /**
     * Create an instance of {@link FindById }
     * 
     */
    public FindById createFindById() {
        return new FindById();
    }

    /**
     * Create an instance of {@link SaveUserResponse }
     * 
     */
    public SaveUserResponse createSaveUserResponse() {
        return new SaveUserResponse();
    }

    /**
     * Create an instance of {@link FindAllUsers }
     * 
     */
    public FindAllUsers createFindAllUsers() {
        return new FindAllUsers();
    }

    /**
     * Create an instance of {@link UpdateUserResponse }
     * 
     */
    public UpdateUserResponse createUpdateUserResponse() {
        return new UpdateUserResponse();
    }

    /**
     * Create an instance of {@link FindTaskByName }
     * 
     */
    public FindTaskByName createFindTaskByName() {
        return new FindTaskByName();
    }

    /**
     * Create an instance of {@link UpdateUserTaskResponse }
     * 
     */
    public UpdateUserTaskResponse createUpdateUserTaskResponse() {
        return new UpdateUserTaskResponse();
    }

    /**
     * Create an instance of {@link SaveUser }
     * 
     */
    public SaveUser createSaveUser() {
        return new SaveUser();
    }

    /**
     * Create an instance of {@link DeleteAllUserTasksResponse }
     * 
     */
    public DeleteAllUserTasksResponse createDeleteAllUserTasksResponse() {
        return new DeleteAllUserTasksResponse();
    }

    /**
     * Create an instance of {@link FindAllUserTasksResponse }
     * 
     */
    public FindAllUserTasksResponse createFindAllUserTasksResponse() {
        return new FindAllUserTasksResponse();
    }

    /**
     * Create an instance of {@link IsUserExistResponse }
     * 
     */
    public IsUserExistResponse createIsUserExistResponse() {
        return new IsUserExistResponse();
    }

    /**
     * Create an instance of {@link UpdateUserTask }
     * 
     */
    public UpdateUserTask createUpdateUserTask() {
        return new UpdateUserTask();
    }

    /**
     * Create an instance of {@link FindByName }
     * 
     */
    public FindByName createFindByName() {
        return new FindByName();
    }

    /**
     * Create an instance of {@link UpdateUser }
     * 
     */
    public UpdateUser createUpdateUser() {
        return new UpdateUser();
    }

    /**
     * Create an instance of {@link IsTaskExistResponse }
     * 
     */
    public IsTaskExistResponse createIsTaskExistResponse() {
        return new IsTaskExistResponse();
    }

    /**
     * Create an instance of {@link FindTaskByNameResponse }
     * 
     */
    public FindTaskByNameResponse createFindTaskByNameResponse() {
        return new FindTaskByNameResponse();
    }

    /**
     * Create an instance of {@link IsUserExist }
     * 
     */
    public IsUserExist createIsUserExist() {
        return new IsUserExist();
    }

    /**
     * Create an instance of {@link IsTaskExist }
     * 
     */
    public IsTaskExist createIsTaskExist() {
        return new IsTaskExist();
    }

    /**
     * Create an instance of {@link SaveTaskResponse }
     * 
     */
    public SaveTaskResponse createSaveTaskResponse() {
        return new SaveTaskResponse();
    }

    /**
     * Create an instance of {@link DeleteTaskOfUserById }
     * 
     */
    public DeleteTaskOfUserById createDeleteTaskOfUserById() {
        return new DeleteTaskOfUserById();
    }

    /**
     * Create an instance of {@link DeleteAllUsers }
     * 
     */
    public DeleteAllUsers createDeleteAllUsers() {
        return new DeleteAllUsers();
    }

    /**
     * Create an instance of {@link FindByIdResponse }
     * 
     */
    public FindByIdResponse createFindByIdResponse() {
        return new FindByIdResponse();
    }

    /**
     * Create an instance of {@link DeleteAllUsersResponse }
     * 
     */
    public DeleteAllUsersResponse createDeleteAllUsersResponse() {
        return new DeleteAllUsersResponse();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link FindAllUsersResponse }
     * 
     */
    public FindAllUsersResponse createFindAllUsersResponse() {
        return new FindAllUsersResponse();
    }

    /**
     * Create an instance of {@link FindUserTaskByIdTaskResponse }
     * 
     */
    public FindUserTaskByIdTaskResponse createFindUserTaskByIdTaskResponse() {
        return new FindUserTaskByIdTaskResponse();
    }

    /**
     * Create an instance of {@link DeleteUserById }
     * 
     */
    public DeleteUserById createDeleteUserById() {
        return new DeleteUserById();
    }

    /**
     * Create an instance of {@link Task }
     * 
     */
    public Task createTask() {
        return new Task();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "saveUserResponse")
    public JAXBElement<SaveUserResponse> createSaveUserResponse(SaveUserResponse value) {
        return new JAXBElement<SaveUserResponse>(_SaveUserResponse_QNAME, SaveUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllUsers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "findAllUsers")
    public JAXBElement<FindAllUsers> createFindAllUsers(FindAllUsers value) {
        return new JAXBElement<FindAllUsers>(_FindAllUsers_QNAME, FindAllUsers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUserTaskResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "updateUserTaskResponse")
    public JAXBElement<UpdateUserTaskResponse> createUpdateUserTaskResponse(UpdateUserTaskResponse value) {
        return new JAXBElement<UpdateUserTaskResponse>(_UpdateUserTaskResponse_QNAME, UpdateUserTaskResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "saveUser")
    public JAXBElement<SaveUser> createSaveUser(SaveUser value) {
        return new JAXBElement<SaveUser>(_SaveUser_QNAME, SaveUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "updateUserResponse")
    public JAXBElement<UpdateUserResponse> createUpdateUserResponse(UpdateUserResponse value) {
        return new JAXBElement<UpdateUserResponse>(_UpdateUserResponse_QNAME, UpdateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindTaskByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "findTaskByName")
    public JAXBElement<FindTaskByName> createFindTaskByName(FindTaskByName value) {
        return new JAXBElement<FindTaskByName>(_FindTaskByName_QNAME, FindTaskByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTaskOfUserByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "deleteTaskOfUserByIdResponse")
    public JAXBElement<DeleteTaskOfUserByIdResponse> createDeleteTaskOfUserByIdResponse(DeleteTaskOfUserByIdResponse value) {
        return new JAXBElement<DeleteTaskOfUserByIdResponse>(_DeleteTaskOfUserByIdResponse_QNAME, DeleteTaskOfUserByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "findById")
    public JAXBElement<FindById> createFindById(FindById value) {
        return new JAXBElement<FindById>(_FindById_QNAME, FindById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveTask }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "saveTask")
    public JAXBElement<SaveTask> createSaveTask(SaveTask value) {
        return new JAXBElement<SaveTask>(_SaveTask_QNAME, SaveTask.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "findByNameResponse")
    public JAXBElement<FindByNameResponse> createFindByNameResponse(FindByNameResponse value) {
        return new JAXBElement<FindByNameResponse>(_FindByNameResponse_QNAME, FindByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllUserTasks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "findAllUserTasks")
    public JAXBElement<FindAllUserTasks> createFindAllUserTasks(FindAllUserTasks value) {
        return new JAXBElement<FindAllUserTasks>(_FindAllUserTasks_QNAME, FindAllUserTasks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "deleteUserByIdResponse")
    public JAXBElement<DeleteUserByIdResponse> createDeleteUserByIdResponse(DeleteUserByIdResponse value) {
        return new JAXBElement<DeleteUserByIdResponse>(_DeleteUserByIdResponse_QNAME, DeleteUserByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAllUserTasks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "deleteAllUserTasks")
    public JAXBElement<DeleteAllUserTasks> createDeleteAllUserTasks(DeleteAllUserTasks value) {
        return new JAXBElement<DeleteAllUserTasks>(_DeleteAllUserTasks_QNAME, DeleteAllUserTasks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindUserTaskByIdTask }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "findUserTaskByIdTask")
    public JAXBElement<FindUserTaskByIdTask> createFindUserTaskByIdTask(FindUserTaskByIdTask value) {
        return new JAXBElement<FindUserTaskByIdTask>(_FindUserTaskByIdTask_QNAME, FindUserTaskByIdTask.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAllUsersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "deleteAllUsersResponse")
    public JAXBElement<DeleteAllUsersResponse> createDeleteAllUsersResponse(DeleteAllUsersResponse value) {
        return new JAXBElement<DeleteAllUsersResponse>(_DeleteAllUsersResponse_QNAME, DeleteAllUsersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllUsersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "findAllUsersResponse")
    public JAXBElement<FindAllUsersResponse> createFindAllUsersResponse(FindAllUsersResponse value) {
        return new JAXBElement<FindAllUsersResponse>(_FindAllUsersResponse_QNAME, FindAllUsersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindUserTaskByIdTaskResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "findUserTaskByIdTaskResponse")
    public JAXBElement<FindUserTaskByIdTaskResponse> createFindUserTaskByIdTaskResponse(FindUserTaskByIdTaskResponse value) {
        return new JAXBElement<FindUserTaskByIdTaskResponse>(_FindUserTaskByIdTaskResponse_QNAME, FindUserTaskByIdTaskResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "deleteUserById")
    public JAXBElement<DeleteUserById> createDeleteUserById(DeleteUserById value) {
        return new JAXBElement<DeleteUserById>(_DeleteUserById_QNAME, DeleteUserById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link User }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "user")
    public JAXBElement<User> createUser(User value) {
        return new JAXBElement<User>(_User_QNAME, User.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTaskOfUserById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "deleteTaskOfUserById")
    public JAXBElement<DeleteTaskOfUserById> createDeleteTaskOfUserById(DeleteTaskOfUserById value) {
        return new JAXBElement<DeleteTaskOfUserById>(_DeleteTaskOfUserById_QNAME, DeleteTaskOfUserById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsTaskExist }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "isTaskExist")
    public JAXBElement<IsTaskExist> createIsTaskExist(IsTaskExist value) {
        return new JAXBElement<IsTaskExist>(_IsTaskExist_QNAME, IsTaskExist.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveTaskResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "saveTaskResponse")
    public JAXBElement<SaveTaskResponse> createSaveTaskResponse(SaveTaskResponse value) {
        return new JAXBElement<SaveTaskResponse>(_SaveTaskResponse_QNAME, SaveTaskResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAllUsers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "deleteAllUsers")
    public JAXBElement<DeleteAllUsers> createDeleteAllUsers(DeleteAllUsers value) {
        return new JAXBElement<DeleteAllUsers>(_DeleteAllUsers_QNAME, DeleteAllUsers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "findByIdResponse")
    public JAXBElement<FindByIdResponse> createFindByIdResponse(FindByIdResponse value) {
        return new JAXBElement<FindByIdResponse>(_FindByIdResponse_QNAME, FindByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "findByName")
    public JAXBElement<FindByName> createFindByName(FindByName value) {
        return new JAXBElement<FindByName>(_FindByName_QNAME, FindByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "updateUser")
    public JAXBElement<UpdateUser> createUpdateUser(UpdateUser value) {
        return new JAXBElement<UpdateUser>(_UpdateUser_QNAME, UpdateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindTaskByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "findTaskByNameResponse")
    public JAXBElement<FindTaskByNameResponse> createFindTaskByNameResponse(FindTaskByNameResponse value) {
        return new JAXBElement<FindTaskByNameResponse>(_FindTaskByNameResponse_QNAME, FindTaskByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsUserExist }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "isUserExist")
    public JAXBElement<IsUserExist> createIsUserExist(IsUserExist value) {
        return new JAXBElement<IsUserExist>(_IsUserExist_QNAME, IsUserExist.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsTaskExistResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "isTaskExistResponse")
    public JAXBElement<IsTaskExistResponse> createIsTaskExistResponse(IsTaskExistResponse value) {
        return new JAXBElement<IsTaskExistResponse>(_IsTaskExistResponse_QNAME, IsTaskExistResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllUserTasksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "findAllUserTasksResponse")
    public JAXBElement<FindAllUserTasksResponse> createFindAllUserTasksResponse(FindAllUserTasksResponse value) {
        return new JAXBElement<FindAllUserTasksResponse>(_FindAllUserTasksResponse_QNAME, FindAllUserTasksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsUserExistResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "isUserExistResponse")
    public JAXBElement<IsUserExistResponse> createIsUserExistResponse(IsUserExistResponse value) {
        return new JAXBElement<IsUserExistResponse>(_IsUserExistResponse_QNAME, IsUserExistResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUserTask }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "updateUserTask")
    public JAXBElement<UpdateUserTask> createUpdateUserTask(UpdateUserTask value) {
        return new JAXBElement<UpdateUserTask>(_UpdateUserTask_QNAME, UpdateUserTask.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAllUserTasksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sushchanka.company.com/", name = "deleteAllUserTasksResponse")
    public JAXBElement<DeleteAllUserTasksResponse> createDeleteAllUserTasksResponse(DeleteAllUserTasksResponse value) {
        return new JAXBElement<DeleteAllUserTasksResponse>(_DeleteAllUserTasksResponse_QNAME, DeleteAllUserTasksResponse.class, null, value);
    }

}
