# Report from Controlled Experiment: Code Review Solo vs. Pairs

**Authors:**

Szymon Haj, 153059

Marcin Stecewicz

Poznan, 22.12.2025

---

## Introduction

This report presents the design and summarizes results of the experiment **"Code Review Solo vs. Pairs: A Comparative Study of Defect Detection Effectiveness"**. The experiment was part of a project realized within the Quality Management and Experimental Software Engineering classes at Poznan University of Technology.

The motivation for this study stems from the ongoing debate in software engineering about the effectiveness of pair programming and collaborative code review practices. While pair programming has been studied extensively, the specific context of code review—where developers systematically examine code to find 
defects—presents unique characteristics that warrant separate investigation. Understanding whether working in pairs improves defect detection during code review has practical implications for software development teams seeking to optimize their quality assurance processes.

---

## Experiment Definition

The goal of the experiment was to:

- **Object of study**: Code review process performed by students
- **Purpose**: Compare and evaluate
- **Quality focus**: Defect detection effectiveness (number of defects found, false positive rate, and time efficiency)
- **Perspective**: From the viewpoint of software developers and quality assurance practitioners
- **Context**: Conducted with 5th-year Computer Science students at Poznan University of Technology in a controlled laboratory setting

**Research Questions:**

- RQ1: Does pair code review result in more defects being detected compared to solo code review?
- RQ2: Is solo code review faster in terms of defect detection speed?

---

## Experiment Design

### Hypotheses

The following hypotheses were formulated a priori:

**H1 (Defect Detection):**
- H1₀: There is no significant difference in the number of defects found between solo and pair code review (μ_pair = μ_solo)
- H1₁: Pairs find significantly more defects than individuals working solo (μ_pair > μ_solo)

**H2 (Time Efficiency):**
- H2₀: There is no significant difference in time to detect defects between solo and pair code review (μ_time_solo = μ_time_pair)
- H2₁: Solo code review is significantly faster in defect detection (μ_time_solo < μ_time_pair)

### Variables and Confounding Factors

**Independent Variable:**
- **Work mode**: Categorical variable with two levels
  - Solo: Individual code review
  - Pair: Two-person collaborative code review

**Dependent Variables:**

1. **Number of defects found**: Continuous variable (0-10 scale)
   - Measurement: Count of valid defects reported by participant/pair
   
2. **False positive rate**: Continuous variable (0-1 scale)
   - Calculation: FP / (True Positives + FP)
   
3. **Time to first defect**: Continuous variable (minutes)
   - Measurement: Timestamp from session start to first valid defect report
   
4. **Average time between defects**: Continuous variable (minutes)
   - Calculation: Total session time / number of defects found

**Controlled Confounding Factors:**

1. **Programming experience**: Controlled through demographic survey; all participants are 5th-year Computer Science students with similar educational background

2. **Learning effect**: Controlled through counterbalancing design—half of participants start with solo review, half start with pair review

3. **Code difficulty**: Controlled by using two code samples (Code A: Binary Search Tree, Code B: User Authentication System) with similar characteristics:
   - Both contain exactly 10 deliberately inserted defects
   - Similar lines of code (~150 LOC each)
   - Similar distribution of defect severity (3 Critical, 4 Major, 3 Minor for Code A; 1 Critical, 6 Major, 3 Minor for Code B)
   - Both represent realistic programming scenarios

4. **Order effects**: Mitigated through counterbalancing—Group 1 reviews Code A then Code B, Group 2 reviews Code B then Code A

5. **Fatigue**: Controlled through 5-minute break between sessions and limiting each session to 30 minutes

**Uncontrolled/Measured Confounding Factors:**

1. **Pair dynamics**: Measured through post-experiment survey questions about participation balance and discussion productivity

2. **Individual confidence**: Measured through post-experiment survey about confidence in found defects

### Participants

**Sample size**: [UZUPELNIJ: actual number] participants

**Target population**: 5th-year Computer Science students at Poznan University of Technology

**Recruitment**: Participants were recruited from PUT University, Software Engineering Course

**Inclusion criteria**: Students enrolled in 5th year of Computer Science program with at least basic Java programming knowledge

**Exclusion criteria**: None applied

### Objects

Two Java code samples were used as objects for review:

**Code A: Binary Search Tree Implementation**
- Language: Java
- Approximate size: ~500 lines of code
- Domain: Data structures
- Complexity: Medium (recursive algorithms, tree traversal)

**Code B: User Authentication System**
- Language: Java
- Approximate size: ~500 lines of code
- Domain: Security/authentication
- Complexity: Medium (cryptography, data structures)

Both code samples contained realistic defects commonly found in real-world code reviews, including null pointer exceptions, security vulnerabilities, logic errors, memory leaks, and style violations.

### Test Definition

**Design type**: Within-subjects repeated measures with counterbalancing

**Assignment strategy**: Participants were assigned to two groups with counterbalanced order of conditions:

**Group 1** ([UZUPELNIJ: N] participants):
- Session 1: Code A - SOLO (individual work)
- Session 2: Code B - PAIRS (paired in groups of 2)

**Group 2** ([UZUPELNIJ: N] participants):
- Session 1: Code A - PAIRS (paired in groups of 2)
- Session 2: Code B - SOLO (individual work)

This design ensures that each participant experiences both conditions (solo and pair), which increases statistical power and controls for individual differences. The counterbalancing controls for order effects and learning effects.

**Pairing strategy**: For pair sessions, participants were paired according to their preferences. Each pair worked at a single computer, following the driver-navigator pattern where both members actively participated in defect identification.

---

## Experiment Operation

### Prepared Instrumentation

The following materials and instruments were prepared for the experiment:

**1. GitHub Repository Structure:**

A dedicated GitHub repository was created with the following structure:
```
code-review-experiment/
├── README.md (instructions and post-experiment survey link)
├── .devcontainer/
│   └── devcontainer.json (GitHub Codespaces configuration)
├── session1/
│   ├── CodeA_BinarySearchTree.java
│   ├── CodeB_UserAuthenticator.java
│   └── Bug_Report.txt
├── session2/
│   ├── CodeA_BinarySearchTree.java
│   ├── CodeB_UserAuthenticator.java
│   └── Bug_Report.txt
└── docs/
    ├── defect-categories.md
    └── reporting-guide.md
```

**2. Technical Environment:**

- **Platform**: GitHub Codespaces with pre-configured Java development environment
- **IDE**: Visual Studio Code with Java extensions
- **Java version**: JDK 17

**3. Participant Instructions (README.md):**

Comprehensive instructions provided to participants including:
- Task description: Review Java code to find defects
- Reporting protocol: Raise hand and verbally report defects immediately when found
- Information to report: Line number, brief description of the defect, severity, and type
- Defect categories reference guide
- Time limits: 30 minutes per session
- Working mode guidelines (solo vs. pair)

**4. Defect Categories Reference (defect-categories.md):**

Participants were provided with clear definitions of:

**Defect types:**
- Security: Authentication, authorization, injection vulnerabilities, sensitive data exposure
- Performance: Memory leaks, inefficient algorithms, unnecessary operations
- Logic: Incorrect behavior, edge cases, wrong algorithms
- Style: Naming conventions, formatting, code conventions

**5. Data Collection Form:**

A structured form was prepared to record:
- Timestamp (elapsed time from session start)
- Session number (1 or 2)
- Participant ID
- Work mode (Solo/Pair)
- Code reviewed (A or B)
- Line number of defect
- Defect description
- Reported severity
- Reported type
- Validity assessment (Y/N/?)

**7. Answer Key:**

A comprehensive answer key was prepared listing defects in each code sample with:
- Exact line numbers
- Justification for each classification

### Execution

**Date and time**: 27.11.2025

**Location**: Poznań

**Duration**: Approximately 60 minutes total

**Procedure:**

The experiment followed this timeline:

**Phase 1: Introduction (10 minutes)**
- Welcomed participants and explained the overall goal
- Briefed participants on their tasks without revealing specific hypotheses
- Explained the reporting protocol
- Assigned participants to Group 1 or Group 2
- Distributed written instructions

**Phase 2: Technical Setup (5 minutes)**
- Participants logged into GitHub Codespaces
- Verified access to assigned code files
- Conducted a test defect report to ensure understanding of the protocol
- Answered any technical questions

**Phase 3: Session 1 (30 minutes)**
- Group 1: Reviewed Code A in SOLO mode
- Group 2: Reviewed Code A in PAIR mode
- Experimenter recorded all defect reports in real-time with timestamps
- Participants were instructed to report defects immediately upon discovery

**Phase 4: Break and Transition (5 minutes)**
- Short break for participants
- Pair assignments for Session 2 were announced
- Participants accessed the second code sample

**Phase 5: Session 2 (30 minutes)**
- Group 1: Reviewed Code B in PAIR mode
- Group 2: Reviewed Code B in SOLO mode
- Continued real-time data collection
- Maintained consistent reporting protocol

**Phase 6: Post-Experiment Survey (5 minutes)**
- Participants completed the Google Forms survey
- Survey link was provided in the repository README
- Participants completed survey individually

**Phase 7: Wrap-up (5 minutes)**
- Brief discussion about the experiment
- Opportunity for participants to ask questions
- Thanks and dismissal

**Data Collection Process:**

During each session, the experimenter:
1. Documented participant/pair ID
2. Did not provide feedback on defect validity during the session

**Post-Experiment Data Processing:**

After the experiment:
1. Each reported defect was validated against the answer key
2. Defects were classified as True Positive (valid) or False Positive (invalid)
3. Survey responses were collected and linked to participant data
4. All data was entered into a structured spreadsheet for analysis

---

## Analysis and Interpretation

### Descriptive Statistics

**Data Completeness:**

[UZUPELNIJ: Report on data completeness]
- Total participants: [UZUPELNIJ]
- Complete data sets (both sessions): [UZUPELNIJ]
- Excluded participants (if any) and reasons: [UZUPELNIJ]
- Survey response rate: [UZUPELNIJ]%

**Defect Detection Results:**

[UZUPELNIJ: Create table with the following structure]

| Metric | Solo (Mean ± SD) | Pair (Mean ± SD) | Min-Max Solo | Min-Max Pair |
|--------|------------------|------------------|--------------|--------------|
| Total defects found | [UZUPELNIJ] | [UZUPELNIJ] | [UZUPELNIJ] | [UZUPELNIJ] |
| False positives | [UZUPELNIJ] | [UZUPELNIJ] | [UZUPELNIJ] | [UZUPELNIJ] |

**Time Metrics:**

[UZUPELNIJ: Create table]

| Metric | Solo (Mean ± SD) | Pair (Mean ± SD) |
|--------|------------------|------------------|
| Time to first defect (minutes) | [UZUPELNIJ] | [UZUPELNIJ] |
| Average time between defects (minutes) | [UZUPELNIJ] | [UZUPELNIJ] |

**Visualizations:**

[UZUPELNIJ: Include the following plots]

1. Box plot comparing total defects found (Solo vs. Pair)
2. Distribution histogram of time to first defect
3. Box plot of false positive rates

**Outlier Analysis:**

[UZUPELNIJ: Identify and discuss any outliers]
- Participants with unusually high/low defect counts: [UZUPELNIJ]
- Unusual time patterns: [UZUPELNIJ]
- Treatment of outliers in analysis: [UZUPELNIJ]

### Hypotheses Testing

**Statistical Test Selection:**

Given the within-subjects repeated measures design, the following tests were selected:

1. **For H1 and H2**: Paired t-test (parametric) or Wilcoxon signed-rank test (non-parametric)
   - Justification: Within-subjects design with continuous dependent variables
   - Assumption checks: [UZUPELNIJ: Report normality tests (Shapiro-Wilk) for each dependent variable]

**Assumption Testing:**

[UZUPELNIJ: Report results of assumption checks]

- Normality (Shapiro-Wilk test): [UZUPELNIJ]
  - Solo defect counts: W = [UZUPELNIJ], p = [UZUPELNIJ]
  - Pair defect counts: W = [UZUPELNIJ], p = [UZUPELNIJ]
- Decision: [Use parametric/non-parametric tests]

**H1: Defect Detection Effectiveness**

*Null Hypothesis (H1₀)*: μ_pair = μ_solo

*Alternative Hypothesis (H1₁)*: μ_pair > μ_solo (one-tailed)

[UZUPELNIJ: Report test results]

- Test used: [Paired t-test / Wilcoxon signed-rank test]
- Test statistic: [t / W] = [UZUPELNIJ]
- Degrees of freedom (if applicable): df = [UZUPELNIJ]
- p-value: p = [UZUPELNIJ]
- Effect size (Cohen's d): d = [UZUPELNIJ]
- Decision: [Reject / Fail to reject] H1₀ at α = 0.05
- Interpretation: [UZUPELNIJ: State whether pairs found significantly more defects]

**H2: Time Efficiency**

*Null Hypothesis (H2₀)*: μ_time_solo = μ_time_pair

*Alternative Hypothesis (H2₁)*: μ_time_solo < μ_time_pair (one-tailed)

[UZUPELNIJ: Report test results for time to first defect]

- Test used: [UZUPELNIJ]
- Test statistic: [UZUPELNIJ]
- p-value: p = [UZUPELNIJ]
- Effect size: d = [UZUPELNIJ]
- Decision: [UZUPELNIJ]
- Interpretation: [UZUPELNIJ]

[UZUPELNIJ: Report test results for average time between defects]

- Test used: [UZUPELNIJ]
- Test statistic: [UZUPELNIJ]
- p-value: p = [UZUPELNIJ]
- Effect size: d = [UZUPELNIJ]
- Decision: [UZUPELNIJ]
- Interpretation: [UZUPELNIJ]

**Power Analysis:**

[UZUPELNIJ: Report power analysis results]

For each non-significant result (if any):
- Observed effect size: [UZUPELNIJ]
- Sample size: N = [UZUPELNIJ]
- Achieved power (1-β): [UZUPELNIJ]
- Minimum detectable effect size at 80% power: [UZUPELNIJ]

**Additional Analyses:**

**False Positive Rate Comparison:**

[UZUPELNIJ: Report comparison]
- Mean FP rate (Solo): [UZUPELNIJ]%
- Mean FP rate (Pair): [UZUPELNIJ]%
- Statistical test: [UZUPELNIJ]
- Result: [UZUPELNIJ]

### Interpretation of Results

**Main Findings:**

[UZUPELNIJ: Provide comprehensive interpretation based on your results. Below is a template based on expected outcomes:]

**RQ1: Do pairs find more defects?**

[UZUPELNIJ: Based on H1 testing, interpret whether pairs were significantly more effective. Example:]
- The results [show/do not show] that pairs found significantly more defects than solo reviewers.
- On average, pairs detected [UZUPELNIJ] defects while solo reviewers detected [UZUPELNIJ] defects.
- The effect size was [small/medium/large] (Cohen's d = [UZUPELNIJ]).
- This [supports/contradicts] the hypothesis that collaboration improves defect detection.

**RQ2: Is solo review faster?**

[UZUPELNIJ: Interpret time efficiency results. Example:]
- Solo reviewers [were/were not] significantly faster in finding the first defect.
- The average time to first defect was [UZUPELNIJ] minutes for solo vs. [UZUPELNIJ] minutes for pairs.
- This [suggests/does not suggest] a time efficiency trade-off in pair reviewing.

**Secondary Findings:**

[UZUPELNIJ: Discuss any additional interesting patterns]

1. **False Positive Rates**: [Interpret whether pairs or solo had fewer false alarms]

2. **Learning Effects**: [Discuss any observed learning between Session 1 and Session 2]

3. **Participant Feedback**: [Summarize survey results about preferences and experiences]

**Practical Implications:**

[UZUPELNIJ: Discuss practical implications of findings. Example:]

The results of this experiment suggest that [pairs/solo review/both approaches] have distinct advantages in code review contexts. For software development teams, this implies that:

- [Implication 1 based on results]
- [Implication 2 based on results]
- [Recommendation for when to use each approach]

**Comparison with Literature:**

[UZUPELNIJ: If time permits, briefly compare findings with related studies on pair programming or code review effectiveness]

---

## Threats to Validity

This section discusses potential threats to the validity of our findings and the measures taken to mitigate them.

### Conclusion Validity

Conclusion validity concerns whether we can correctly infer a relationship between treatment and outcome.

**Threat 1: Small Sample Size**

- *Description*: With approximately [UZUPELNIJ] participants, statistical power may be limited to detect small effects.
- *Mitigation*: Within-subjects design was chosen to increase statistical power by controlling for individual differences. Each participant served as their own control, effectively doubling the amount of data compared to a between-subjects design.
- *Residual risk*: Power analysis [UZUPELNIJ: report if showed adequate power]. If power was insufficient, we acknowledge that non-significant results may represent Type II errors rather than true null effects.

**Threat 2: Reliability of Measurements**

- *Description*: Defect classification (severity and type) involves subjective judgment, which could introduce measurement error.
- *Mitigation*: A detailed answer key was prepared in advance with clear criteria for each defect. A single experimenter classified all defects consistently using this key.
- *Residual risk*: Some ambiguity remains in borderline cases, though these were minimized through clear defect definitions.

**Threat 3: Violation of Statistical Test Assumptions**

- *Description*: Parametric tests assume normality of distributions and homogeneity of variance.
- *Mitigation*: Normality was tested using Shapiro-Wilk test. [UZUPELNIJ: If assumptions violated] Non-parametric alternatives (Wilcoxon signed-rank test) were used when assumptions were violated.
- *Residual risk*: Minimal, as appropriate tests were selected based on data characteristics.

### Internal Validity

Internal validity concerns whether the observed effects can be attributed to the independent variable rather than confounding factors.

**Threat 1: Learning Effects**

- *Description*: Participants might improve their code review skills between Session 1 and Session 2, potentially confounding treatment effects with learning effects.
- *Mitigation*: Counterbalancing was implemented—half the participants started with solo review and half started with pair review. This ensures learning effects are distributed equally across both conditions.
- *Impact*: [UZUPELNIJ: Analyze if Group 1 and Group 2 showed different patterns suggesting learning]
- *Residual risk*: Learning effects may still occur but should be balanced across conditions.

**Threat 2: Fatigue Effects**

- *Description*: Participants might perform worse in Session 2 due to mental fatigue from Session 1.
- *Mitigation*: 
  - A 5-minute break was provided between sessions
  - Each session was limited to 30 minutes to prevent excessive fatigue
  - Counterbalancing ensures fatigue affects both conditions equally
- *Residual risk*: Some fatigue may still occur, but effects should be balanced.

**Threat 3: Code Difficulty Imbalance**

- *Description*: If Code A and Code B differ substantially in difficulty, this could confound results.
- *Mitigation*: 
  - Both codes were designed with 10 defects each
  - Similar length (~150 LOC)
  - Similar distribution of severity levels
  - [UZUPELNIJ: Report perceived difficulty from survey]
- *Analysis*: Post-experiment survey asked participants to rate difficulty of each code. [UZUPELNIJ: Report if significant difference was found and how it was addressed in analysis]
- *Residual risk*: Minor differences may exist despite efforts to balance difficulty.

**Threat 4: Hawthorne Effect**

- *Description*: Participants may alter their behavior because they know they are being observed and studied.
- *Mitigation*: While difficult to eliminate entirely, participants were told the study's general purpose without revealing specific hypotheses, reducing demand characteristics.
- *Residual risk*: High. Participants knew they were being evaluated, which may have increased motivation in both conditions. However, this effect should be consistent across conditions.

**Threat 5: Pair Dynamics Variability**

- *Description*: Different pairs may have vastly different collaboration dynamics (dominant vs. balanced), introducing noise in the pair condition.
- *Mitigation*: 
  - Post-experiment survey measured pair dynamics
  - [UZUPELNIJ: Report assignment method] Pairs were [randomly assigned / matched by experience]
  - Analysis can examine whether pair dynamics correlated with performance
- *Residual risk*: Moderate. Personality differences and collaboration skills vary, which is inherent to pair work.

### Construct Validity

Construct validity concerns whether the measured variables truly represent the theoretical constructs of interest.

**Threat 1: Artificial Defects**

- *Description*: Deliberately inserted defects may not reflect the distribution and subtlety of real-world bugs.
- *Mitigation*: Defects were chosen to represent common, realistic issues found in actual code reviews (null pointer exceptions, security vulnerabilities, logic errors, memory leaks, style violations).
- *Residual risk*: Moderate. Real code reviews involve unknown numbers and types of defects, which changes the search process.

**Threat 2: Time Pressure Effects**

- *Description*: The 30-minute time limit may not reflect typical code review conditions.
- *Mitigation*: Time limit was set to simulate a focused review session, which is common in practice. The limit was the same for both conditions.
- *Residual risk*: Moderate. Real code reviews may be more relaxed or more rushed depending on context.

### External Validity

External validity concerns the generalizability of findings to other contexts, populations, and settings.

**Threat 1: Student Sample**

- *Description*: 5th-year computer science students may differ from professional software developers in experience, motivation, and skills.
- *Mitigation*: 
  - Participants were senior students with several years of programming experience
  - Demographic data was collected to characterize the sample
  - Results are explicitly framed as applicable to this population
- *Residual risk*: High. Generalization to professional developers requires caution. The study should be replicated with professional samples.

**Threat 2: Laboratory Setting**

- *Description*: The controlled laboratory environment differs from real software development settings.
- *Mitigation*: GitHub Codespaces provided a realistic development environment, and tasks were designed to simulate actual code review.
- *Residual risk*: Moderate. Real code reviews involve broader context (project history, domain knowledge, etc.) that was absent here.

**Threat 3: Limited Code Samples**

- *Description*: Only two code samples in Java were used; results may not generalize to other programming languages or domains.
- *Mitigation*: Code samples represented different domains (data structures vs. security) to increase variety.
- *Residual risk*: High. Generalization to other languages (e.g., Python, JavaScript) or paradigms (e.g., functional programming) requires additional studies.

**Threat 4: Task Specificity**

- *Description*: Findings apply to code review but may not generalize to other collaborative programming activities (e.g., pair programming during development, architectural design).
- *Mitigation*: The study explicitly focuses on code review as a distinct activity.
- *Residual risk*: Minimal for code review context; high for other activities.

### Summary of Validity Assessment

[UZUPELNIJ: Provide brief summary assessment]

The experimental design incorporated several important controls (within-subjects design, counterbalancing, clear instrumentation) that strengthen internal and conclusion validity. The primary limitations concern external validity—particularly the student sample and laboratory setting—which limit generalization to professional software development contexts. Future research should replicate this study with professional developers in more naturalistic settings.

---

## Conclusions

[UZUPELNIJ: Write comprehensive conclusions based on your actual results. Below is a template:]

This experiment investigated the effectiveness of pair code review compared to solo code review in terms of defect detection and time efficiency. Using a within-subjects repeated measures design with [UZUPELNIJ] participants, we found that:

**Key Findings:**

1. [UZUPELNIJ: State main finding about defect detection (H1)]

2. [UZUPELNIJ: State main finding about time efficiency (H2)]

**Theoretical Contributions:**

[UZUPELNIJ: Discuss how findings contribute to understanding of collaborative software engineering practices]

**Practical Implications:**

[UZUPELNIJ: Provide actionable recommendations for software development teams]

**Limitations:**

The main limitations of this study include:
- Small sample size of [UZUPELNIJ] participants
- Use of student participants rather than professional developers
- Controlled laboratory setting with artificial time constraints
- Limited to Java code and two specific code samples

**Future Work:**

[UZUPELNIJ: Suggest directions for future research, such as:]
- Replication with professional developers
- Investigation of different code complexities and domains
- Longer-term studies examining learning effects
- Analysis of communication patterns in pair code review
- Cost-benefit analysis of pair vs. solo review in industry settings
