# MovieMD Learning Plan

Goal: relearn the basics of Hilt, Kotlin and Jetpack Compose by building the MovieMD app.
Each lesson changes something visible in the app. Concept first, then code.

## Phase 1: Hilt basics (done)

- [x] Gradle setup (version catalog, Hilt plugin, KSP)
- [x] `@HiltAndroidApp` on the Application class, `@AndroidEntryPoint` on `MainActivity`
- [x] `@HiltViewModel` and `@Inject constructor`
- [x] `@Binds` (interface to implementation) vs `@Provides` (library objects)
- [x] Repository chain: `HomeVM` -> `MovieRepository` -> `MovieFakeDataSource`
- [ ] Later, when needed: qualifiers (`@Named`), scopes beyond `@Singleton`, Hilt testing

## Phase 2: Compose basics

| # | Lesson | Visible result in app |
|---|---|---|
| 1 | Composables and recomposition: what `@Composable` means, why a function re-runs | `MovieCard` composable |
| 2 | Layouts and modifiers: `Row`, `Column`, `Box`, modifier order, `LazyColumn` | Styled card list |
| 3 | State: `remember`, `mutableStateOf`, how `collectAsState` relates | Favorite toggle on a card |
| 4 | State hoisting: state down, events up | Stateless `MovieCard` plus a `HomePage` that owns state |
| 5 | UI state in the ViewModel: `sealed interface`, loading / error / success | `HomeUiState` with spinner and retry |
| 6 | Material 3 and theming: colors, typography, common components | Themed Home screen |
| 7 | Side effects: `LaunchedEffect` and friends | Actions on screen load |

## Phase 3: Kotlin, learned in context

Picked up inside the lessons above, not as a separate course:

- [ ] Null safety: `?`, `?:`, `!!`
- [ ] Lambdas and trailing lambda syntax
- [ ] `data class`, `data object`, `sealed` types
- [ ] Extension and scope functions: `let`, `apply`
- [ ] Coroutines and Flow: `viewModelScope`, `StateFlow`

## Phase 4: Real app features

- [ ] Retrofit + TMDB API (uses `@Provides` in `GlobalModule`)
- [ ] Navigation and a detail screen
- [ ] Room for caching and favorites
- [ ] Testing the ViewModel with a fake repository

## Working agreement

- Claude explains the concept first, the user types and copies the code.
- Break things on purpose to learn the error messages.
