package com.vedic.astro.exception;

/**
 * Constants file for managing error codes and messages.
 * 
 * @author Sumeer Saxena
 *
 */
public interface ErrorConstants {
	
	// System error code and message
	public static final String SYSTEM_FAILURE_CODE = "systemFailure";
	public static final String SYSTEM_FAILURE_MESSAGE = 
			"Some unexpected failure has happened, check the logs for more details";
 
	// Person with emailID passed already exists.
	public static final String EMAIL_EXISTS_CODE = "emailExists";
	public static final String EMAIL_EXISTS_MESSAGE = "Person with this emailID already exists";

	// Authentication failure
	public static final String AUTH_FAILURE_CODE = "authFailure";
	public static final String AUTH_FAILURE_MESSAGE = "Authentication failed";
	
	// Photo upload error messages
	public static final String INVALID_FILE_TYPE_CODE = "invalidFileType";
	public static final String INVALID_FILE_TYPE_MESSAGE = "The file you are uploading is not of type image";
	
	public static final String FILE_SIZE_EXCEEDED_CODE = "fileSizeExceeded";
	public static final String FILE_SIZE_EXCEEDED_MESSAGE = "The size of the file you are uploading exceeds 5 MB";
	
	public static final String PHYSICIAN_DONT_EXISTS_CODE = "physicianDoesNotExist";
	public static final String PHYSICIAN_DONT_EXISTS_MESSAGE = "The Physician does not exist";

	public static final String MEMBER_DONT_EXISTS_CODE = "memberDoesNotExist";
	public static final String MEMBER_DONT_EXISTS_MESSAGE = "The Member does not exist";
	
	// Nurse associated with Physician
	public static final String NURSE_ASSOCIATED_CODE = "nurseAssociated";
	public static final String NURSE_ASSOCIATED_MESSAGE = "Nurse cannot be deleted as it is associated with Physician(s)";

	// Member associated with Care Groups
	public static final String MEMBER_ASSOCIATED_CODE = "memberAssociated";
	public static final String MEMBER_ASSOCIATED_MESSAGE = "Member cannot be deleted as it is associated with CareGroup(s)";

	// CareGroup is associated with Members
	public static final String PHYSICIAN_ASSOCIATED_CODE = "careGroupAssociatedWithMembers";
	public static final String PHYSICIAN_ASSOCIATED_MESSAGE = "The Care Group cannot be deleted as it is associated with Member(s)";

	// Nurse with given PID does not exist.
	public static final String NURSE_DOES_NOT_EXIST_CODE = "nurseDoesNotExist";
	public static final String NURSE_DOES_NOT_EXIST_MESSAGE = "Nurse with this pid does not exist";


	// Physician with given PID does not exist.
	public static final String PHYSICIAN_DOES_NOT_EXIST_CODE = "physicianDoesNotExist";
	public static final String PHYSICIAN_DOES_NOT_EXIST_MESSAGE = "Physician with this pid does not exist";

	// Member with given PID does not exist.
	public static final String MEMBER_DOES_NOT_EXIST_CODE = "memberDoesNotExist";
	public static final String MEMBER_DOES_NOT_EXIST_MESSAGE = "Member with this pid does not exist";

	// PID cannot be null for updating .
	public static final String PID_MISSING_CODE = "pidMissing";
	public static final String PID_MISSING_MESSAGE = "Pid is missing";

	// Attributes not present .
	public static final String ATTRIBUTE_DOES_NOT_EXIST_CODE = "attributeDoesNotExist";
	public static final String ATTRIBUTE_DOES_NOT_EXIST_MESSAGE = " attribute does not exist in collection";
	
	// User not present .
	public static final String USER_DOES_NOT_EXIST_CODE = "userDoesNotExist";
	public static final String USER_DOES_NOT_EXIST_MESSAGE = "The user with this pid does not exist in CRM system";
	
	// Token not present .
	public static final String TOKEN_DOES_NOT_EXIST_CODE = "tokenDoesNotExist";
	public static final String TOKEN_DOES_NOT_EXIST_MESSAGE = "Registration link has expired. Please contact Genophen to proceed.";

	// Token has expired .
	public static final String TOKEN_EXPIRED_CODE = "tokenExpired";
	public static final String TOKEN_EXPIRED_MESSAGE = "Your registration token has expired. Please contact support@genophen.com to renew your token.";

	// Cannot delete a registered user .
	public static final String CANNOT_DELETE_REGISTERED_USER_CODE = "cannotDeleteRegisteredUser";
	public static final String CANNOT_DELETE_REGISTERED_USER_MESSAGE = "The user cannot be deleted as it is registered in Genophen application";
	
	// Enterprise group with given ID does not exist.
	public static final String ENTERPRISE_GROUP_DOES_NOT_EXIST_CODE = "enterpriseGroupDoesNotExist";
	public static final String ENTERPRISE_GROUP_DOES_NOT_EXIST_MESSAGE = " Enterprise group id does not exist";
	
	// Member is not an enterprise group member
	public static final String MEMBER_DOES_NOT_BELONG_TO_ENTERPRISE_GROUP_CODE = "memberDoesNotBelongToEnterpriseGroup";
	public static final String MEMBER_DOES_NOT_BELONG_TO_ENTERPRISE_GROUP_MESSAGE = "This Member does not belong to any Enterprise group";

	// Enterprise group with the name already exists.
	public static final String ENTERPRISE_GROUP_NAME_ALREADY_EXISTS_CODE = "enterpriseGroupNameExists";
	public static final String ENTERPRISE_GROUP_NAME_ALREADY_EXISTS_MESSAGE = "This Enterprise group name already exists";
	
	// Enterprise group admin with given PID does not exist.
	public static final String ENTERPRISE_GROUP_ADMIN_DOES_NOT_EXIST_CODE = "enterpriseGroupAdminDoesNotExist";
	public static final String ENTERPRISE_GROUP_ADMIN_DOES_NOT_EXIST_MESSAGE = "Enterprise Group admin with this pid does not exist";

	// Member is not an enterprise group member.
	public static final String MEMBER_NOT_ENTERPRISE_GROUP_MEMBER_CODE = "memberNotEnterpriseGroupMember";
	public static final String MEMBER_NOT_ENTERPRISE_GROUP_MEMBER_MESSAGE = "The given member is not an enterprise group member";
	
	// Enterprise group not specified.
	public static final String ENTERPRISE_GROUP_MANDATORY_CODE = "enterpriseGroupMandatory";
	public static final String ENTERPRISE_GROUP_MANDATORY_MESSAGE = "Enterprise group is mandatory, cannot be null";

	// Roles is mandatory.
	public static final String ROLES_MANDATORY_CODE = "rolesMandatory";
	public static final String ROLES_MANDATORY_MESSAGE = "Roles is mandatory, cannot be null";

	// Patient with the given Illumina KIT ID does not exist.
	public static final String ILLUMINA_KIT_DOES_NOT_EXIST_CODE = "illuminaDoesNotExist";
	public static final String ILLUMINA_KIT_DOES_NOT_EXIST_MESSAGE = "Patient with the given Illumina KIT ID does not exist";

	// Consent is mandatory.
	public static final String CONSENT_MANDATORY_CODE = "consentMandatory";
	public static final String CONSENT_MANDATORY_MESSAGE = "Consent of the member is mandatory for enrollment";
	
	// Max patients limit reached
	public static final String MAX_PATIENTS_LIMIT_CODE = "maxPatientsLimitReached";
	public static final String MAX_PATIENTS_LIMIT_MESSAGE = "The Physician has reached the max limit of patients";

	// Nurse can be introduced only by physician
	public static final String NURSE_NOT_INTRODUCED_BY_PHYSICIAN_CODE = "nurseNotIntroducedByPhysician";
	public static final String NURSE_NOT_INTRODUCED_BY_PHYSICIAN_MESSAGE = "The nurse can only be introduced only by a physician.";

	// Member can be introduced only by physician or e-admin
	public static final String MEMBER_NOT_INTRODUCED_BY_PHYSICIAN_EADMIN_CODE = "memberNotIntroducedByPhysicianOrEadmin";
	public static final String MEMBER_NOT_INTRODUCED_BY_PHYSICIAN_EADMIN_MESSAGE = "The member can be introduced only by a physician or an e-admin";

	// Physician can be introduced only by physician or member
	public static final String PHYSICIAN_NOT_INTRODUCED_BY_MEMBER_EADMIN_CODE = "physicianNotIntroducedByMemberOrEadmin";
	public static final String PHYSICIAN_NOT_INTRODUCED_BY_MEMBER_EADMIN_MESSAGE = "The physician can be introduced only by a member or an e-admin";

	// Cannot add patient to EG caregroup as physician has not signed up for part of EG program
	public static final String PHYSICIAN_NOT_PART_OF_EG_PROGRAM_CODE = "physicianNotPartOfEG";
	public static final String PHYSICIAN_NOT_PART_OF_EG_PROGRAM_MESSAGE = "The physician is not part of EG program";
	
	// Physician is already associated with a nurse
	public static final String PHYSICIAN_HAS_NURSE_ASSOCIATED_CODE = "physicianHasNurseAssociated";
	public static final String PHYSICIAN_HAS_NURSE_ASSOCIATED_MESSAGE = "The physician already has a nurse associated";
	
	// Enrollment token already exist.
	public static final String ENROLLMENT_TOKEN_EXIST_CODE = "enrollmentTokenExist";
	public static final String ENROLLMENT_TOKEN_EXIST_MESSAGE = "Enrollment token already exist";

	// Enrollment token already exist.
	public static final String ENROLLMENT_TOKEN_DOES_NOT_EXIST_CODE = "enrollmentTokenDoesNotExist";
	public static final String ENROLLMENT_TOKEN_DOES_NOT_EXIST_MESSAGE = "Enrollment token does not exist";

	// System error code and message
	public static final String INVALID_INPUT_CODE = "invalidInput";
	public static final String INVALID_INPUT_MESSAGE = 
 			"Invalid input, check errors";
	
	// System error code and message
	public static final String NURSE_ALREADY_MEMBER_CODE = "nurseAlreadyMember";
	public static final String NURSE_ALREADY_MEMBER_CODE_MESSAGE = 
			"Nurse is already a member ";

	// System error code and message
	public static final String MAX_PATIENTS_EG_PHYSICIAN_CODE = "maxPatientsEGPhysician";
	public static final String MAX_PATIENTS_EG_PHYSICIAN_MESSAGE = 
			"Max - ";

	// System error code and message
	public static final String MAX_PATIENTS_EG_PHYSICIAN_POSITIVE_CODE = "maxPatientsEGPhysician";
	public static final String MAX_PATIENTS_EG_PHYSICIAN_POSITIVE_MESSAGE = 
			"Max > 0 ";

	// Cannot add member to unassigned physician
	public static final String CANNOT_ADD_MEMBER_TO_UNASSIGNED_EG_PHYSICIAN_CODE = "cannotAddMemberToUnassignedEGPhysician";
	public static final String CANNOT_ADD_MEMBER_TO_UNASSIGNED_EG_PHYSICIAN_MESSAGE = 
			"Cannot add member to unassigned EG physician's caregroup";

	// Account Locked
	public static final String AUTH_LOGIN_LOCKED = "loginLocked";
	public static final String AUTH_LOGIN_LOCKED_MESSAGE = "Account Locked. Please contact Administrator to unlock your account";

	// Username does not exist
	public static final String AUTH_INVALID_USERNAME_CODE = "invalidUsername";
	public static final String AUTH_INVALID_USERNAME_MESSAGE = "Invalid username";
	
	// Notification does not exist
	public static final String INVALID_NOTIFICATION_CODE = "invalidNotification";
	public static final String INVALID_NOTIFICATION_MESSAGE = "Invalid notification or already sent";
	
	// Physician already enrolled
	public static final String PHYSICIAN_ALREADY_ENROLLED_CODE = "physicianAlreadyEnrolled";
	public static final String PHYSICIAN_ALREADY_ENROLLED_MESSAGE = "The physician has already enrolled";

	// Invite code is not alphanumeric.
	public static final String INVITE_CODE_INVALID_CODE = "inviteCodeInvalid";
	public static final String INVITE_CODE_INVALID_CODE_MESSAGE = "Invite code is invalid";

	// Nurse not associated with physician
	public static final String NURSE_NOT_ASSOCIATED_WITH_PHYSICIAN_CODE = "nurseNotAssociatedWithPhysician";
	public static final String NURSE_NOT_ASSOCIATED_WITH_PHYSICIAN_MESSAGE = "Nurse not associated with physician";
}
