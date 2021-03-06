package com.google.mu.util;

import com.google.mu.function.CheckedRunnable;
import com.google.mu.function.CheckedSupplier;

/**
 * Result of a previously evaluated condition. Used to fluently chain API calls like
 * {@code Optionals.ifPresent()}. For example: <pre>
 *   ifPresent(getStory(), Story::tell)
 *       .or(() -> ifPresent(getJoke(), Joke::tell))
 *       .orElse(() -> print("can't tell"));
 * </pre>
 *
 * @since 1.14
 */
public interface Premise {
  /** Evaluates {@code alternative} if {@code this} premise doesn't hold. */
  <E extends Throwable> Premise or(CheckedSupplier<? extends Premise, E> alternative) throws E;

  /** Runs {@code block} if {@code this} premise doesn't hold. */
  <E extends Throwable> void orElse(CheckedRunnable<E> block) throws E;
}
