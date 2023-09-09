# Continuous Integration with GitHub Actions[^1]

Continuous Integration (CI) is a practice that involves developers integrating code into a shared repository several times a day. Each
integration is then verified by an automated build and automated tests. This approach allows teams to detect problems early and solve them
more easily.

For this purpose, GitHub Actions are used.

## GitHub Actions

GitHub Actions is a CI/CD tool that allows developers to automate software workflows directly in GitHub repositories. The workflows you
design are completely customizable and can be set up to take care of a variety of tasks including testing your projects, diagnosing bugs,
managing issues, and deploying applications. Relying on GitHub Actions for your project's continuous integration can simplify your workflow,
increase productivity and reduce overhead managing multiple tools.

- Actions are defined in the `.github/workflows/` directory, with each file in this path representing a separate GitHub Action.

- With a free account, GitHub Actions provides 2000 minutes of CI runtime per month for private repositories. Public repositories do not
  have this limit.

- GitHub Actions provides runners for macOS, Windows, and Linux, which means you can test your application across different operating
  systems within a single pipeline. Potentially the macOS runner could be used to build iOS apps. However there is a minutes multiplier for
  macOS runners that are 10x more expensive than Linux runners.

- GitHub Actions workflows can be intentionally skipped for specific commits by appending `[skip ci]` or `[ci skip]` to your commit
  messages. However, this does not apply to PR titles.

### Testing GitHub Actions

- You don’t need to test or tweak your workflows in your main branch. You can modify your GitHub Actions to only be triggered on push events
  for a specific branch.

```yaml
on:
  push:
    branches:
      - test-actions
```

In the above snippet, the workflow will only run when changes are pushed to the `test-actions` branch.

- GitHub Actions has a `workflow_dispatch` event that lets you manually trigger workflows. You need to include this event to the action's
  YAML file.

- [act][act] is a tool that can be used to test GitHub Actions workflows locally before pushing changes to GitHub.

[act]: https://github.com/nektos/act

[^1]: AI generated based on my input
