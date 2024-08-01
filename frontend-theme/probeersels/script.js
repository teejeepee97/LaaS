document.addEventListener("DOMContentLoaded", () => {
  const manageEnrollmentButtons = document.querySelectorAll(
    ".manage-enrollment-btn"
  );
  const pathAnalyticsButtons = document.querySelectorAll(".path-analytics-btn");
  const modifyContentButtons = document.querySelectorAll(".modify-content-btn");

  manageEnrollmentButtons.forEach((button) => {
    button.addEventListener("click", () => {
      alert("Manage Enrollment clicked");
    });
  });

  pathAnalyticsButtons.forEach((button) => {
    button.addEventListener("click", () => {
      alert("Path Analytics clicked");
    });
  });

  modifyContentButtons.forEach((button) => {
    button.addEventListener("click", () => {
      alert("Modify Content clicked");
    });
  });
});
